package com.randstaddigital.workshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "stations")
public class StationEntity {

  @Id @GeneratedValue private UUID id;
  private String name;
  private Double longitude;
  private Double latitude;
  private int maximumBikeCapacity;
}
