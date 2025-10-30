package com.senai.Flora.Infrastructure.repository;

import com.senai.Flora.domain.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
