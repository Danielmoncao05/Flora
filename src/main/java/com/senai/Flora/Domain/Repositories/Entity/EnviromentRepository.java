package com.senai.Flora.Domain.Repositories.Entity;

import com.senai.Flora.Domain.Entities.Entity.Register.enviroment.Enviroment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnviromentRepository extends JpaRepository<Enviroment, Long> {
}
