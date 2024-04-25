package com.randstaddigital.workshop.service;

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

  public Rental startRental(UUID bikeId, UUID userId) {
    var bikeResponse = bikeService.getBikeById(bikeId);
    if (bikeResponse.isEmpty()) {
      throw new ResponseStatusException(NOT_FOUND);
    }
    var bike = bikeResponse.get();
    var rental =
        Rental.builder()
            .userId(userId)
            .bikeId(bike.getId())
            .start(OffsetDateTime.now())
            .startStationId(bike.getStationId())
            .build();

    return rentalMapper.toModel(rentalRepository.saveAndFlush(rentalMapper.toEntity(rental)));
  }

  public Rental endRental(UUID id, UUID endStationId) {
    return getRentalById(id)
        .map(rental -> endRental(rental, endStationId))
        .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
  }

  private Rental endRental(Rental rental, UUID endStationId) {
    rental.setEndStationId(endStationId);
    // TODO Update station in bike

    return rentalMapper.toModel(rentalRepository.saveAndFlush(rentalMapper.toEntity(rental)));
  }
}
