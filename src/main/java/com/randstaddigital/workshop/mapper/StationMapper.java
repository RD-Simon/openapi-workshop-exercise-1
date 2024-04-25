package com.randstaddigital.workshop.mapper;

import com.randstaddigital.workshop.dto.StationDto;
import com.randstaddigital.workshop.entity.StationEntity;
import com.randstaddigital.workshop.model.Station;
import org.mapstruct.Mapper;

@Mapper
public interface StationMapper {

  Station toModel(StationEntity station);

  Station toModel(StationDto station);

  StationEntity toEntity(Station station);

  StationDto toDto(Station station);
}
