package com.randstaddigital.workshop.service;

import com.randstaddigital.workshop.mapper.StationMapper;
import com.randstaddigital.workshop.model.Station;
import com.randstaddigital.workshop.repository.StationRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StationService {

  private final StationRepository stationRepository;
  private final StationMapper stationMapper;

  public List<Station> getAllStations() {
    return stationRepository.findAll().stream().map(stationMapper::toModel).toList();
  }

  public Optional<Station> getStationById(UUID id) {
    return stationRepository.findById(id).map(stationMapper::toModel);
  }
}
