package com.senai.Flora.Domain.Repositories.Entity;

import com.senai.Flora.Domain.Entities.Entity.Register.user.ClientFlora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientFlora, Long> {
}
