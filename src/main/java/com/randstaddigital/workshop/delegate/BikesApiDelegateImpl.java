package com.randstaddigital.workshop.delegate;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import com.randstaddigital.workshop.api.BikesApiDelegate;
import com.randstaddigital.workshop.dto.BikeDto;
import com.randstaddigital.workshop.dto.BikeTypeDto;
import com.randstaddigital.workshop.dto.RentBikeRequestDto;
import com.randstaddigital.workshop.dto.RentalDto;
import com.randstaddigital.workshop.mapper.BikeMapper;
import com.randstaddigital.workshop.mapper.RentalMapper;
import com.randstaddigital.workshop.model.Bike;
import com.randstaddigital.workshop.model.Rental;
import com.randstaddigital.workshop.service.BikeService;
import com.randstaddigital.workshop.service.RentalService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BikesApiDelegateImpl implements BikesApiDelegate {

  private final BikeService bikeService;
  private final BikeMapper bikeMapper;
  private final RentalService rentalService;
  private final RentalMapper rentalMapper;

  @Override
  public ResponseEntity<Void> deleteBike(UUID bikeId) {
    bikeService.deleteBikeById(bikeId);

    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<BikeDto> getBike(UUID bikeId) {
    return bikeService
        .getBikeById(bikeId)
        .map(bikeMapper::toDto)
        .map(bike -> new ResponseEntity<>(bike, OK))
        .orElse(new ResponseEntity<>(NOT_FOUND));
  }

  @Override
  public ResponseEntity<List<BikeDto>> getBikes(
      String brand, BikeTypeDto bikeType, Boolean electrified) {
    var filter =
        Bike.builder()
            .brand(brand)
            .type(bikeMapper.toModel(bikeType))
            .electrified(electrified)
            .build();
    return new ResponseEntity<>(
        bikeService.getAllBikes(filter).stream().map(bikeMapper::toDto).toList(), OK);
  }

  @Override
  public ResponseEntity<RentalDto> rentBike(UUID bikeId, RentBikeRequestDto rentBikeRequestDto) {
    var userId = rentBikeRequestDto.getUserId();
    return rentalService
        .getRentalByBikeIdAndUserId(bikeId, userId)
        .map(this::createExistingRentalResponseEntity)
        .orElseGet(() -> createNewRentalResponseEntity(bikeId, userId));
  }

  private ResponseEntity<RentalDto> createNewRentalResponseEntity(UUID bikeId, UUID userId) {
    return new ResponseEntity<>(
        rentalMapper.toDto(rentalService.startRental(bikeId, userId)), CREATED);
  }

  private ResponseEntity<RentalDto> createExistingRentalResponseEntity(Rental rental) {
    return new ResponseEntity<>(rentalMapper.toDto(rental), OK);
  }
}
