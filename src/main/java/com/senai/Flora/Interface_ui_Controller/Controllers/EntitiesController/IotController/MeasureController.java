package com.senai.Flora.Interface_ui_Controller.Controllers.EntitiesController.IotController;

import com.senai.Flora.Application.DTOs.Entities.IoT.MeasureDTO;
import com.senai.Flora.Application.Services.Entities.IoT.MeasureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measure")
public class MeasureController {

    private final MeasureService service;

    public MeasureController(MeasureService service) {
        this.service = service;
    }

    @PostMapping
    public MeasureDTO createMeasure (@RequestBody MeasureDTO dto) {
        return service.registerMeasure(dto);
    }

    @GetMapping
    public ResponseEntity<List<MeasureDTO>> listMeasures () {
        return ResponseEntity.ok(service.listMeasures());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeasureDTO> searchId (@PathVariable Long id) {
        return service.searchForId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMeasure (@PathVariable Long id , @RequestBody MeasureDTO dto) {
        if (service.updateMeasure(id, dto)) {
            return ResponseEntity.ok("Measure updated!!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeMeasure (@PathVariable Long id) {
        if (service.removeMeasure(id)) {
            return ResponseEntity.ok("Measure removed!!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
