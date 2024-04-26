package com.randstaddigital.workshop.delegate;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import com.randstaddigital.workshop.api.UsersApiDelegate;
import com.randstaddigital.workshop.dto.RentalDto;
import com.randstaddigital.workshop.dto.UserDto;
import com.randstaddigital.workshop.mapper.RentalMapper;
import com.randstaddigital.workshop.mapper.UserMapper;
import com.randstaddigital.workshop.service.RentalService;
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
  private final RentalService rentalService;
  private final RentalMapper rentalMapper;

  @Override
  public ResponseEntity<List<RentalDto>> getRentalsByUser(UUID userId) {
    return new ResponseEntity<>(
        rentalService.getRentalsByUserId(userId).stream().map(rentalMapper::toDto).toList(), OK);
  }

  @Override
  public ResponseEntity<UserDto> getUser(UUID userId) {
    return userService
        .getUserById(userId)
        .map(userMapper::toDto)
        .map(station -> new ResponseEntity<>(station, OK))
        .orElse(new ResponseEntity<>(NOT_FOUND));
  }

  @Override
  public ResponseEntity<List<UserDto>> getUsers() {
    return new ResponseEntity<>(
        userService.getAllUsers().stream().map(userMapper::toDto).toList(), OK);
  }
}
