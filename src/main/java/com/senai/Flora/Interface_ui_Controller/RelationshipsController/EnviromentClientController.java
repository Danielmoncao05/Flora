package com.senai.Flora.Interface_ui_Controller.RelationshipsController;

import com.senai.Flora.Application.DTOs.Relationships.EnviromentClientDTO;
import com.senai.Flora.Application.Services.Relationships.EnviromentClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enviroment-client")
public class EnviromentClientController {

    private final EnviromentClientService service;

    public EnviromentClientController(EnviromentClientService service) {
        this.service = service;
    }

    @PostMapping
    public EnviromentClientDTO createEnviromentClient (@RequestBody EnviromentClientDTO dto) {
        return service.registerRelation(dto);
    }

    @GetMapping
    public ResponseEntity<List<EnviromentClientDTO>> listEnviromentClients () {
        return ResponseEntity.ok(service.listEnviromentClient());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnviromentClientDTO> searchId (@PathVariable Long id) {
        return service.searchForId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEnviromentClient (@PathVariable Long id , @RequestBody EnviromentClientDTO dto) {
        if (service.updateEnviromentClient(id, dto)) {
            return ResponseEntity.ok("Enviroment Client updated");
        } else  {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeEnviromentClient (@PathVariable Long id ) {
        if (service.removeEnviromentClient(id)) {
            return ResponseEntity.ok("Enviroment Client removed");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
