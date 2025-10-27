package com.senai.Flora.Interface_ui_Controller.EntitiesController.ClientController;

import com.senai.Flora.Application.DTOs.Entities.Register.NotificationDTO;
import com.senai.Flora.Application.Services.Entities.Register.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    public NotificationDTO newNotification (@RequestBody NotificationDTO dto) {
        return service.registerNotification(dto);
    }

    public ResponseEntity<List<NotificationDTO>> listNotifications() {
        return ResponseEntity.ok(service.listNotifications());
    }

    public ResponseEntity<NotificationDTO> searchForId(Long id) {
        return service.searchId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<String> updateNotification (Long id , NotificationDTO dto) {
        if (service.updatenNotification(id, dto)) {
            return ResponseEntity.ok("Notification updated!!");
        } else  {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deleteNotification (Long id) {
        if (service.removeNotification(id)) {
            return ResponseEntity.ok("Notification removed !!!!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
