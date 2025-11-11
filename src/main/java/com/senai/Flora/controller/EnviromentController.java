package com.senai.Flora.controller;

import com.senai.Flora.Infrastructure.dto.EnviromentDTO;
import com.senai.Flora.application.service.EnviromentService;
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

    // * basico pra buscar o usuario

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<EnviromentDTO>> getByUser(@PathVariable Long userId){
        List<EnviromentDTO> list = service.getEnvironmentsByUserId(userId);
        return ResponseEntity.ok(list);
    }

    //------------------------------------------------------------

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
