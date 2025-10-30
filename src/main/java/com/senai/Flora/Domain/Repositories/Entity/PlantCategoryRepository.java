package com.senai.Flora.Domain.Repositories.Entity;

import com.senai.Flora.Domain.Entities.Entity.Register.Plant.PlantCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantCategoryRepository extends JpaRepository<PlantCategory , Long > {
}
