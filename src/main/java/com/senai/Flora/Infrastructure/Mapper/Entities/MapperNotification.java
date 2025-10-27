package com.senai.Flora.Infrastructure.Mapper.Entities;

import com.senai.Flora.Application.DTOs.Entities.Register.NotificationDTO;
import com.senai.Flora.Domain.Entities.Entity.IoT.Sens;
import com.senai.Flora.Domain.Entities.Entity.Register.user.Notification;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;

@Component
public class MapperNotification {

    private final EntityManager entityManager;

    public MapperNotification(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Notification toEntity (NotificationDTO dto) {
        if (dto == null) return null;
        Notification notification = new Notification();

        notification.setSens(entityManager.getReference(Sens.class, dto.id_Sens()));

        return notification;
    }

    public NotificationDTO toDTO (Notification notification) {
        if (notification == null) return null;
        return new NotificationDTO(
                notification.getId_Notification(),
                notification.getSens().getId_Sens()
        );
    }

}
