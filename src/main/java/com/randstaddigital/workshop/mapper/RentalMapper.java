package com.randstaddigital.workshop.mapper;

import com.randstaddigital.workshop.dto.RentalDto;
import com.randstaddigital.workshop.entity.RentalEntity;
import com.randstaddigital.workshop.model.Rental;
import org.mapstruct.Mapper;

@Mapper
public interface RentalMapper {

  Rental toModel(RentalEntity rental);

  Rental toModel(RentalDto rental);

  RentalEntity toEntity(Rental rental);

  RentalDto toDto(Rental rental);
}
