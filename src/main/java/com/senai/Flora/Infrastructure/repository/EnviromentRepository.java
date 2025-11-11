package com.senai.Flora.Infrastructure.repository;

import com.senai.Flora.domain.Enviroment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnviromentRepository extends JpaRepository<Enviroment, Long> {

    List<Enviroment> findByOwner_IdClient(Long ownerId); // *
}
