package com.senai.Flora.Interface_ui_Controller.RelationshipsController.MeasureSens;

import com.senai.Flora.Application.DTOs.Relationships.MeasureSens.MeasureSensDTO;
import com.senai.Flora.Application.Services.Relationships.MeasureSensService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measure-sens")
public class MeasureSensController {

    private final MeasureSensService service;

    public MeasureSensController(MeasureSensService service) {
        this.service = service;
    }

    @PostMapping
    public MeasureSensDTO createMeasureSens (@RequestBody MeasureSensDTO dto) {
        return service.registerMeasureSens(dto);
    }

    @GetMapping
    public ResponseEntity<List<MeasureSensDTO>> listMeasureSens () {
        return ResponseEntity.ok(service.listMeasureSens());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeasureSensDTO> searchId (@PathVariable Long id) {
        return service.searchForId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMeasureSens (@PathVariable Long id , @RequestBody MeasureSensDTO dto) {
        if (service.updateMeasureSens(id, dto)) {
            return ResponseEntity.ok("Measure-sens updated!!!");
        } else  {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeMeasureSens (@PathVariable Long id) {
        if (service.removeMeasureSens(id)) {
            return ResponseEntity.ok("Measure-Sens removed sucessly");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
