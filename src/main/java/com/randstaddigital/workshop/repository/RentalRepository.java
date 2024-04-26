package com.randstaddigital.workshop.repository;

import com.randstaddigital.workshop.entity.RentalEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<RentalEntity, UUID> {

  Optional<RentalEntity> findByBikeIdAndUserId(UUID bikeId, UUID userId);

  List<RentalEntity> findByUserId(UUID userId);
}
