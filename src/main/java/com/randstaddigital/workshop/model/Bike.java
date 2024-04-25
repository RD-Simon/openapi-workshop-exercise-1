package com.randstaddigital.workshop.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Bike {
  private UUID id;
  private LocalDate dayOfPurchase;
  private UUID stationId;
  private String brand;
  private boolean electrified;
  private BikeType type;
}
