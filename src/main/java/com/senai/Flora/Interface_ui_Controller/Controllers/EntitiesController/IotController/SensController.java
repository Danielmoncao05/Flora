package com.senai.Flora.Interface_ui_Controller.Controllers.EntitiesController.IotController;

import com.senai.Flora.Application.DTOs.Entities.IoT.SensDTO;
import com.senai.Flora.Application.Services.Entities.IoT.SensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sens")
public class SensController {

    @Autowired
    private SensService service;

    @PostMapping
    public SensDTO newSens (@RequestBody SensDTO dto) {
        return service.registerSens(dto);
    }

    @GetMapping
    public ResponseEntity<List<SensDTO>> listSens () {
        return ResponseEntity.ok(service.listSens());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensDTO> listForId (@PathVariable Long id) {
        return service.searchForId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSens (@PathVariable Long id , @RequestBody SensDTO dto) {
        if (service.updateSens(id, dto)) {
            return ResponseEntity.ok("Sens updated!!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeSens (@PathVariable Long id) {
        if (service.removeSens(id)) {
            return ResponseEntity.ok("Sens removed !!!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 }
