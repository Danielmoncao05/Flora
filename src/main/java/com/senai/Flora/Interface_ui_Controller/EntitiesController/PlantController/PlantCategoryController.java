package com.senai.Flora.Interface_ui_Controller.EntitiesController.PlantController;

import com.senai.Flora.Application.DTOs.Entities.Register.PlantCategoryDTO;
import com.senai.Flora.Application.Services.Entities.Register.PlantCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plant-category")
public class PlantCategoryController {

    private final PlantCategoryService service;

    public PlantCategoryController(PlantCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public PlantCategoryDTO newPlantCategory (@RequestBody PlantCategoryDTO dto) {
        return service.createPlantCategory(dto);
    }

    @GetMapping
    public ResponseEntity<List<PlantCategoryDTO>> listPlantCategory() {
        return ResponseEntity.ok(service.listPlantCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantCategoryDTO> searchId (@PathVariable Long id) {
        return service.searchForId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlantCategory (@PathVariable Long id, @RequestBody PlantCategoryDTO dto) {
        if (service.updatePlantCategory(id, dto)) {
            return ResponseEntity.ok("Plant category updated");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlantCategory (@PathVariable Long id) {
        if (service.removePlantCategory(id)) {
            return ResponseEntity.ok("Plant category removed !!!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
