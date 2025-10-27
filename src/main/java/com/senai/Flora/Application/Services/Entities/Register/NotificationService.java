package com.senai.Flora.Application.Services.Entities.Register;

import com.senai.Flora.Application.DTOs.Entities.Register.NotificationDTO;
import com.senai.Flora.Domain.Entities.Entity.Register.user.Notification;
import com.senai.Flora.Domain.Repositories.Entity.NotificationRepository;
import com.senai.Flora.Infrastructure.Mapper.Entities.MapperNotification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    private final MapperNotification mapper;

    public NotificationService(NotificationRepository repository, MapperNotification mapper) {
        this.repository = repository;
        this.mapper = mapper;
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
            notification.getSens().setId_Sens(dto.id_Sens());
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
