package com.randstaddigital.workshop.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
public class Rental {
  private UUID id;
  private UUID userId;
  private UUID bikeId;
  private OffsetDateTime start;
  private UUID startStationId;
  private OffsetDateTime end;
  private UUID endStationId;
}
