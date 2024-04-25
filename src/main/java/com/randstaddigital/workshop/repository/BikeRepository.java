package com.randstaddigital.workshop.repository;

import com.randstaddigital.workshop.entity.BikeEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepository extends JpaRepository<BikeEntity, UUID> {

  List<BikeEntity> findAllByStationId(UUID stationId);
}
