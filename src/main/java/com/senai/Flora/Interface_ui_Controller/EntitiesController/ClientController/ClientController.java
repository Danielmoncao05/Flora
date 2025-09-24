package com.senai.Flora.Interface_ui_Controller.EntitiesController.ClientController;


import com.senai.Flora.Application.DTOs.Entities.Register.ClientDTO;
import com.senai.Flora.Application.Services.Entities.Register.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ClientDTO newClient (@RequestBody ClientDTO dto) {
        return clientService.registerClient(dto);
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> listenClients () {
        return ResponseEntity.ok(clientService.listingClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> listenForId (@PathVariable Long id) {
        return clientService.searchForId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient(@PathVariable Long id, @RequestBody ClientDTO dto) {
        if (clientService.updateClient(id, dto)) {
            return ResponseEntity.ok("Client Updated!!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeClient (@PathVariable Long id) {
        if (clientService.removeClient(id)) {
            return ResponseEntity.ok("Client removed!!");
        } else  {
            return ResponseEntity.notFound().build();
        }
    }
}
