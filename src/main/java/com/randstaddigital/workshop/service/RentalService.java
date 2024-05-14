package com.randstaddigital.workshop.service;

import static java.time.OffsetDateTime.now;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.randstaddigital.workshop.mapper.RentalMapper;
import com.randstaddigital.workshop.model.Rental;
import com.randstaddigital.workshop.repository.RentalRepository;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class RentalService {

  private final RentalRepository rentalRepository;
  private final RentalMapper rentalMapper;
  private final BikeService bikeService;

  public List<Rental> getAllRentals() {
    return rentalRepository.findAll().stream().map(rentalMapper::toModel).toList();
  }

  public Optional<Rental> getRentalById(UUID id) {
    return rentalRepository.findById(id).map(rentalMapper::toModel);
  }

  public Optional<Rental> getRentalByBikeIdAndUserId(UUID bikeId, UUID userId) {
    return rentalRepository.findByBikeIdAndUserId(bikeId, userId).map(rentalMapper::toModel);
  }

  public List<Rental> getRentalsByUserId(UUID userId) {
    return rentalRepository.findByUserId(userId).stream().map(rentalMapper::toModel).toList();
  }

  public Rental startRental(UUID bikeId, UUID userId) {
    return bikeService
        .getBikeById(bikeId)
        .map(
            bike ->
                Rental.builder()
                    .userId(userId)
                    .bikeId(bike.getId())
                    .start(now())
                    .startStationId(bike.getStationId())
                    .build())
        .map(rentalMapper::toEntity)
        .map(rentalRepository::saveAndFlush)
        .map(rentalMapper::toModel)
        .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
  }

  public Rental endRental(UUID id, UUID endStationId) {
    return getRentalById(id)
        .map(rental -> endRental(rental, endStationId))
        .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
  }

  private Rental endRental(Rental rental, UUID endStationId) {
    rental.setEndStationId(endStationId).setEnd(now());

    bikeService.updateEndStation(rental.getBikeId(), endStationId);

    return rentalMapper.toModel(rentalRepository.saveAndFlush(rentalMapper.toEntity(rental)));
  }

  public boolean isWithinTimeRange(Rental rental, OffsetDateTime starting, OffsetDateTime ending) {
    if (starting == null && ending == null) {
      return true;
    }
    if (starting == null) {
      return ending.isAfter(rental.getStart());
    }
    if (ending == null) {
      return starting.isBefore(rental.getStart())
          || rental.getEnd() == null
          || starting.isBefore(rental.getEnd());
    }
    return ending.isAfter(rental.getStart())
        && (starting.isBefore(rental.getStart())
            || rental.getEnd() == null
            || starting.isBefore(rental.getEnd()));
  }
}
