package com.senai.Flora.Interface_ui_Controller.EntitiesController;

import com.senai.Flora.Application.DTOs.Entities.Register.EnviromentDTO;
import com.senai.Flora.Application.Services.Entities.Register.EnviromentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enviroment")
public class EnviromentController {

    @Autowired
    private EnviromentService service;

    @PostMapping
    public EnviromentDTO newEnviroment (@RequestBody EnviromentDTO dto) {
        return service.registerEnviroment(dto);
    }

    @GetMapping
    public ResponseEntity<List<EnviromentDTO>> listEnviroments () {
        return ResponseEntity.ok(service.listEnviroments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnviromentDTO> listenForId (@PathVariable Long id) {
        return service.searchForId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEnviroment (@PathVariable Long id, @RequestBody EnviromentDTO dto) {
        if (service.updateEnviroment(id, dto)) {
            return ResponseEntity.ok("Enviroment updated!!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeEnviroment (@PathVariable Long id) {
        if (service.removeEnviroment(id)) {
            return ResponseEntity.ok("Enviroment removed!!!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
