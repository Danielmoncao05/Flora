package com.senai.Flora.Infrastructure.repository;

import com.senai.Flora.domain.ClientFlora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientFlora, Long> {
}
