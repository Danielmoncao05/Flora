package com.senai.Flora.Infrastructure.repository;

import com.senai.Flora.domain.Enviroment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnviromentRepository extends JpaRepository<Enviroment, Long> {
}
