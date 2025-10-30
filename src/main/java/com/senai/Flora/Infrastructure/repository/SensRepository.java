package com.senai.Flora.Infrastructure.repository;

import com.senai.Flora.domain.Sens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensRepository extends JpaRepository<Sens, Long> {
}
