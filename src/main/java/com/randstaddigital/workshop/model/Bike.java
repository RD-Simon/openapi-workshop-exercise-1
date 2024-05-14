package com.randstaddigital.workshop.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
public class Bike {
  private UUID id;
  private LocalDate dayOfPurchase;
  private UUID stationId;
  private String brand;
  private Boolean electrified;
  private BikeType type;
}
