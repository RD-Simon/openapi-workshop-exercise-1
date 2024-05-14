package com.randstaddigital.workshop.security;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class AuthTokenSecurityConfig {

  public static final String AUTH_HEADER_NAME = "X-API-KEY";

  @Value("${spring.security.api.key}")
  private String authToken;

  @Bean
  public AuthenticationManager noopAuthenticationManager() {
    return authentication -> {
      throw new AuthenticationServiceException("Authentication is disabled");
    };
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc)
      throws Exception {
    return http.securityMatcher("/**")
        .csrf(AbstractHttpConfigurer::disable)
        .headers(headers -> headers.frameOptions(FrameOptionsConfig::disable))
        .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
        .addFilterBefore(createApiKeyFilter(), UsernamePasswordAuthenticationFilter.class)
        .authorizeHttpRequests(
            authorizeHttpRequests ->
                authorizeHttpRequests
                    .requestMatchers(mvc.pattern("/actuator/*"))
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .build();
  }

  @Scope("prototype")
  @Bean
  MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
    return new MvcRequestMatcher.Builder(introspector);
  }

  private AuthTokenFilter createApiKeyFilter() {
    var filter = new AuthTokenFilter(AUTH_HEADER_NAME);
    filter.setAuthenticationManager(
        authentication -> {
          var principal = (String) authentication.getPrincipal();
          if (!Objects.equals(authToken, principal)) {
            throw new BadCredentialsException("The given API key is incorrect");
          }
          authentication.setAuthenticated(true);
          return authentication;
        });
    return filter;
  }
}
