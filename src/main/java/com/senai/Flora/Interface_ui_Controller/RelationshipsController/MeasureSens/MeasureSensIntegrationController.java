package com.senai.Flora.Interface_ui_Controller.RelationshipsController.MeasureSens;

import com.senai.Flora.Application.DTOs.Relationships.MeasureSens.MeasureSensFullDTO;
import com.senai.Flora.Application.Services.Relationships.MeasureSensIntegrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measure-sens/integration")
public class MeasureSensIntegrationController {

    private final MeasureSensIntegrationService service;

    public MeasureSensIntegrationController(MeasureSensIntegrationService service) {
        this.service = service;
    }

//    @GetMapping
//    public ResponseEntity<List<MeasureSensFullDTO>> listCompleteMeasure(){
//        return ResponseEntity.ok(service.listMeasures());
//    }


    @PostMapping("/{id}")
    public String analyze ( @PathVariable Long id) {
        MeasureSensFullDTO dto = service.buscarFullPorId(id);
        String resultado = service.enviarDadosApiIa(dto);
        return resultado;
    }
}
