package com.randstaddigital.workshop.service;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

import com.randstaddigital.workshop.mapper.BikeMapper;
import com.randstaddigital.workshop.model.Bike;
import com.randstaddigital.workshop.repository.BikeRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class BikeService {

  private final BikeRepository bikeRepository;
  private final BikeMapper bikeMapper;

  public List<Bike> getAllBikes(Bike filter) {
    return bikeRepository.findAll(Example.of(bikeMapper.toEntity(filter))).stream()
        .map(bikeMapper::toModel)
        .toList();
  }

  public Optional<Bike> getBikeById(UUID id) {
    return bikeRepository.findById(id).map(bikeMapper::toModel);
  }

  public List<Bike> getBikesByStationId(UUID stationId) {
    return bikeRepository.findAllByStationId(stationId).stream().map(bikeMapper::toModel).toList();
  }

  public List<Bike> getBikesByStationId(Bike bikeFilter) {
    return bikeRepository.findAll(Example.of(bikeMapper.toEntity(bikeFilter))).stream()
        .map(bikeMapper::toModel)
        .toList();
  }

  public Bike updateEndStation(UUID bikeId, UUID endStationId) {
    return getBikeById(bikeId)
        .map(bike -> bike.setStationId(endStationId))
        .map(bikeMapper::toEntity)
        .map(bikeRepository::saveAndFlush)
        .map(bikeMapper::toModel)
        .orElseThrow(() -> new ResponseStatusException(UNPROCESSABLE_ENTITY));
  }

  public void deleteBikeById(UUID id) {
    bikeRepository.deleteById(id);
  }
}
