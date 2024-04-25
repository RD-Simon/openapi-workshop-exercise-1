package com.randstaddigital.workshop.delegate;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import com.randstaddigital.workshop.api.StationsApiDelegate;
import com.randstaddigital.workshop.dto.BikeDto;
import com.randstaddigital.workshop.dto.StationDto;
import com.randstaddigital.workshop.mapper.BikeMapper;
import com.randstaddigital.workshop.mapper.StationMapper;
import com.randstaddigital.workshop.service.BikeService;
import com.randstaddigital.workshop.service.StationService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StationsApiDelegateImpl implements StationsApiDelegate {

  private final StationService stationService;
  private final StationMapper stationMapper;
  private final BikeService bikeService;
  private final BikeMapper bikeMapper;

  @Override
  public ResponseEntity<List<BikeDto>> getBikesByStation(UUID stationId) {
    return new ResponseEntity<>(
        bikeService.getBikesByStationId(stationId).stream().map(bikeMapper::toDto).toList(), OK);
  }

  @Override
  public ResponseEntity<StationDto> getStation(UUID stationId) {
    return stationService
        .getStationById(stationId)
        .map(stationMapper::toDto)
        .map(station -> new ResponseEntity<>(station, OK))
        .orElse(new ResponseEntity<>(NOT_FOUND));
  }

  @Override
  public ResponseEntity<List<StationDto>> getStations() {
    return new ResponseEntity<>(
        stationService.getAllStations().stream().map(stationMapper::toDto).toList(), OK);
  }
}
