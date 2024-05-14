package com.randstaddigital.workshop.delegate;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import com.randstaddigital.workshop.api.RentalsApiDelegate;
import com.randstaddigital.workshop.dto.EndRentalRequestDto;
import com.randstaddigital.workshop.dto.RentalDto;
import com.randstaddigital.workshop.mapper.RentalMapper;
import com.randstaddigital.workshop.service.RentalService;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalsApiDelegateImpl implements RentalsApiDelegate {

  private final RentalService rentalService;
  private final RentalMapper rentalMapper;

  @Override
  public ResponseEntity<RentalDto> endRental(
      UUID rentalId, EndRentalRequestDto endRentalRequestDto) {
    return new ResponseEntity<>(
        rentalMapper.toDto(
            rentalService.endRental(rentalId, endRentalRequestDto.getEndStationId())),
        OK);
  }

  @Override
  public ResponseEntity<RentalDto> getRental(UUID rentalId) {
    return rentalService
        .getRentalById(rentalId)
        .map(rentalMapper::toDto)
        .map(rental -> new ResponseEntity<>(rental, OK))
        .orElse(new ResponseEntity<>(NOT_FOUND));
  }

  @Override
  public ResponseEntity<List<RentalDto>> getRentals(
      OffsetDateTime starting, OffsetDateTime ending) {
    return new ResponseEntity<>(
        rentalService.getAllRentals().stream()
            .filter(rental -> rentalService.isWithinTimeRange(rental, starting, ending))
            .map(rentalMapper::toDto)
            .toList(),
        OK);
  }
}
