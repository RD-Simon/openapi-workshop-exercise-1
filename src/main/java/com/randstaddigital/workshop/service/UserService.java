package com.randstaddigital.workshop.service;

import com.randstaddigital.workshop.mapper.UserMapper;
import com.randstaddigital.workshop.model.User;
import com.randstaddigital.workshop.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public List<User> getAllUsers() {
    return userRepository.findAll().stream().map(userMapper::toModel).toList();
  }

  public Optional<User> getUserById(UUID id) {
    return userRepository.findById(id).map(userMapper::toModel);
  }
}
