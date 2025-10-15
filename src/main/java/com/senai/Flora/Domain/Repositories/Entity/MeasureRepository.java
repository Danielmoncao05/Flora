package com.senai.Flora.Domain.Repositories.Entity;

import com.senai.Flora.Domain.Entities.Entity.IoT.Measure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasureRepository extends JpaRepository<Measure , Long> {
}
