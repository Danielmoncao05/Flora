package com.senai.Flora.Domain.Repositories.Entity;

import com.senai.Flora.Domain.Entities.Entity.Register.user.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification , Long> {
}
