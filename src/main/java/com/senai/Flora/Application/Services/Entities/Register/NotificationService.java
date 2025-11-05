package com.senai.Flora.Application.Services.Entities.Register;

import com.senai.Flora.Application.DTOs.Entities.Register.NotificationDTO;
import com.senai.Flora.Domain.Entities.Entity.IoT.Sens;
import com.senai.Flora.Domain.Entities.Entity.Register.user.Notification;
import com.senai.Flora.Domain.Repositories.Entity.NotificationRepository;
import com.senai.Flora.Domain.Repositories.Entity.SensRepository;
import com.senai.Flora.Infrastructure.Mapper.Entities.IoT.MapperSens;
import com.senai.Flora.Infrastructure.Mapper.Entities.MapperNotification;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    private final MapperNotification mapper;

    private final EntityManager entityManager;

    public NotificationService(NotificationRepository repository, MapperNotification mapper , EntityManager entityManager) {
        this.repository = repository;
        this.mapper = mapper;
        this.entityManager = entityManager;
    }

    public NotificationDTO registerNotification (NotificationDTO dto) {
        Notification save = repository.save(mapper.toEntity(dto));
        return mapper.toDTO(save);
    }

    public List<NotificationDTO> listNotifications () {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public Optional<NotificationDTO> searchId (Long id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    public boolean updatenNotification (Long id , NotificationDTO dto) {
        return repository.findById(id).map(notification -> {

            // take sens and alternate for a new reference of Sens existent
            notification.setSens(entityManager.getReference(Sens.class , dto.id_Sens()));


            notification.setAttributionDate(LocalDate.now());

            repository.save( notification);

            return true;

        }).orElse(false);
    }

    public boolean removeNotification(Long id) {
        return repository.findById(id).map(notification -> {
            repository.deleteById(id);
            return true;

        }).orElse(false);
    }

}
