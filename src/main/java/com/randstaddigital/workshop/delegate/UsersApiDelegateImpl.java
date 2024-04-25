package com.randstaddigital.workshop.delegate;

import com.randstaddigital.workshop.api.UsersApiDelegate;
import com.randstaddigital.workshop.dto.RentalDto;
import com.randstaddigital.workshop.dto.UserDto;
import com.randstaddigital.workshop.mapper.UserMapper;
import com.randstaddigital.workshop.service.UserService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersApiDelegateImpl implements UsersApiDelegate {

  private final UserService userService;
  private final UserMapper userMapper;

  @Override
  public ResponseEntity<List<RentalDto>> getRentalsByUser(UUID userId) {
    return UsersApiDelegate.super.getRentalsByUser(userId);
  }

  @Override
  public ResponseEntity<UserDto> getUser(UUID userId) {
    return UsersApiDelegate.super.getUser(userId);
  }

  @Override
  public ResponseEntity<List<UserDto>> getUsers() {
    return UsersApiDelegate.super.getUsers();
  }
}
