package com.randstaddigital.workshop.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Station {
  private UUID id;
  private String name;
  private Double longitude;
  private Double latitude;
  private int maximumBikeCapacity;
}
