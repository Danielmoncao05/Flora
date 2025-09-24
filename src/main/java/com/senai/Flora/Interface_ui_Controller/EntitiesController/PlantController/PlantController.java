package com.senai.Flora.Interface_ui_Controller.EntitiesController.PlantController;

import com.senai.Flora.Application.DTOs.Entities.Register.PlantDTO;
import com.senai.Flora.Application.Services.Entities.Register.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService service;

    @PostMapping
    public PlantDTO newPlant (@RequestBody PlantDTO dto) {
        return service.registerPlant(dto);
    }

    @GetMapping
    public ResponseEntity<List<PlantDTO>> listPlants () {
        return ResponseEntity.ok(service.listPlants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantDTO> listenForId (@PathVariable Long id) {
        return service.searchForId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlant (@PathVariable Long id , @RequestBody PlantDTO dto) {
        if (service.updatePlant(id, dto)) {
            return ResponseEntity.ok("Plant updated!!");
        } else  {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removePlant (@PathVariable Long id) {
        if (service.removePlant(id)) {
            return ResponseEntity.ok("Plant removed!!");
        } else  {
            return ResponseEntity.notFound().build();
        }
    }
}