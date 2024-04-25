package com.randstaddigital.workshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rentals")
public class RentalEntity {

  @Id @GeneratedValue private UUID id;
  private UUID userId;
  private UUID bikeId;
  private OffsetDateTime start;
  private UUID startStationId;
  private OffsetDateTime end;
  private UUID endStationId;
}
