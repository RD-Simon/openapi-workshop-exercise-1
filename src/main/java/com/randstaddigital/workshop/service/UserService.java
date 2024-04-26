package com.randstaddigital.workshop.service;

import com.randstaddigital.workshop.mapper.UserMapper;
import com.randstaddigital.workshop.model.User;
import com.randstaddigital.workshop.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public List<User> getAllUsers() {
    var result = userRepository.findAll();
    log.info(result);
    return userRepository.findAll().stream().map(userMapper::toModel).toList();
  }

  public Optional<User> getUserById(UUID id) {
    return userRepository.findById(id).map(userMapper::toModel);
  }
}
