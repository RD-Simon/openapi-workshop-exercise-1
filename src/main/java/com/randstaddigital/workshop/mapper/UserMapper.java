package com.randstaddigital.workshop.mapper;

import com.randstaddigital.workshop.dto.UserDto;
import com.randstaddigital.workshop.entity.UserEntity;
import com.randstaddigital.workshop.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

  User toModel(UserEntity user);

  User toModel(UserDto user);

  UserEntity toEntity(User user);

  UserDto toDto(User user);
}
