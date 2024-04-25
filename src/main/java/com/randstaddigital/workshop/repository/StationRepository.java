package com.randstaddigital.workshop.repository;

import com.randstaddigital.workshop.entity.StationEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<StationEntity, UUID> {}
