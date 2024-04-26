package com.randstaddigital.workshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
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
@Table(name = "bikes")
public class BikeEntity {

  @Id @GeneratedValue private UUID id;
  private LocalDate dayOfPurchase;
  private UUID stationId;
  private String brand;
  private Boolean electrified;
  private BikeTypeEntity type;
}
