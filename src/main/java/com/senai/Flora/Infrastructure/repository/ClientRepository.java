package com.senai.Flora.Infrastructure.repository;

import com.senai.Flora.domain.ClientFlora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientFlora, Long> {

    Optional<ClientFlora> findByEmailAndPassword(String email, String password);// *
}
