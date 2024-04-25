package com.randstaddigital.workshop.mapper;

import com.randstaddigital.workshop.dto.BikeDto;
import com.randstaddigital.workshop.dto.BikeTypeDto;
import com.randstaddigital.workshop.entity.BikeEntity;
import com.randstaddigital.workshop.entity.BikeTypeEntity;
import com.randstaddigital.workshop.model.Bike;
import com.randstaddigital.workshop.model.BikeType;
import org.mapstruct.Mapper;

@Mapper
public interface BikeMapper {
  Bike toModel(BikeEntity bike);

  Bike toModel(BikeDto bike);

  BikeEntity toEntity(Bike bike);

  BikeDto toDto(Bike bike);

  BikeType toModel(BikeTypeEntity bikeType);

  BikeType toModel(BikeTypeDto bikeType);

  BikeTypeEntity toEntity(BikeType bikeType);

  BikeTypeDto toDto(BikeType bikeType);
}
