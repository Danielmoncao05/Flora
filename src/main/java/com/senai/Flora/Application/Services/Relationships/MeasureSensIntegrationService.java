package com.senai.Flora.Application.Services.Relationships;

import com.senai.Flora.Application.DTOs.Relationships.MeasureSens.MeasureSensDTO;
import com.senai.Flora.Application.DTOs.Relationships.MeasureSens.MeasureSensFullDTO;
import com.senai.Flora.Domain.Entities.Relationships.MeasureSens;
import com.senai.Flora.Domain.Repositories.Relationships.MeasureSensRepository;
import com.senai.Flora.Infrastructure.Mapper.Relationships.MapperMeasureSens;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeasureSensIntegrationService {

    private final RestTemplate restTemplate;

    private final MeasureSensRepository repository;

    private final MapperMeasureSens mapperMeasureSens;

    public MeasureSensIntegrationService(RestTemplate restTemplate, MeasureSensRepository repository, MapperMeasureSens mapperMeasureSens) {
        this.restTemplate = restTemplate;
        this.repository = repository;
        this.mapperMeasureSens = mapperMeasureSens;
    }

    public MeasureSensFullDTO buscarFullPorId(Long id) {
        MeasureSens measureSens = repository.findById(id).orElseThrow( () -> new RuntimeException("Measures sens  nao encontrado com id " + id));
        return mapperMeasureSens.toFullDTO(measureSens);
    }


    public String enviarDadosApiIa (MeasureSensFullDTO dto) {
        String url = "http://localhost:8081/analyze";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<MeasureSensFullDTO> request = new HttpEntity<>(dto, headers);

        try{
            return restTemplate.postForObject(url, dto, String.class);
        } catch (Exception e) {
            return "Erro ao enviar dados para Api flora" + e.getMessage();
        }
    }

//    public List<MeasureSensFullDTO> listMeasures () {
//        return repository.findAll().stream().map(mapperMeasureSens::toFullDTO).collect(Collectors.toList());
//    }


}
