package com.randstaddigital.workshop.security;

import static jakarta.servlet.DispatcherType.ERROR;
import static jakarta.servlet.DispatcherType.FORWARD;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.web.SecurityFilterChain;

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
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http.csrf(AbstractHttpConfigurer::disable)
        .headers(headers -> headers.frameOptions(FrameOptionsConfig::disable))
        .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
        .addFilter(createApiKeyFilter())
        .authorizeHttpRequests(
            requests ->
                requests
                    .dispatcherTypeMatchers(FORWARD, ERROR)
                    .permitAll()
                    .requestMatchers("/bike-rental/v1/actuator", "/bike-rental/v1/actuator/*")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .build();
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
