package com.senai.Flora.Interface_ui_Controller.RelationshipsController.EnviromentPlant;

import com.senai.Flora.Application.DTOs.Relationships.EnviromentPlantDTO;
import com.senai.Flora.Application.Services.Relationships.EnviromentPlantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enviroment-plant")
public class EnviromentPlantController {

    private final EnviromentPlantService service;

    public EnviromentPlantController(EnviromentPlantService service) {
        this.service = service;
    }

    @PostMapping
    public EnviromentPlantDTO createEnviromentPlant (@RequestBody EnviromentPlantDTO dto) {
        return service.registerEnviromentPlant(dto);
    }

    @GetMapping
    public ResponseEntity<List<EnviromentPlantDTO>> listEnviromentPlant () {
        return ResponseEntity.ok(service.listEnviromentPlant());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnviromentPlantDTO> listForId (@PathVariable Long id) {
        return service.searchForId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEnviromentPlant (@PathVariable Long id, @RequestBody EnviromentPlantDTO dto) {
        if (service.updateEnviromentPlant(id, dto)) {
            return ResponseEntity.ok("Enviroment plant updated!!!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeEnviromentPlant (@PathVariable Long id) {
        if (service.removeEnviromentPlant(id)){
            return ResponseEntity.ok("Enviroment plant removed!!!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
