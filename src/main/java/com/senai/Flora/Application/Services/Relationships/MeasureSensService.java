package com.senai.Flora.Application.Services.Relationships;

import com.senai.Flora.Application.DTOs.Relationships.MeasureSensDTO;
import com.senai.Flora.Domain.Entities.Entity.IoT.Measure;
import com.senai.Flora.Domain.Entities.Entity.IoT.Sens;
import com.senai.Flora.Domain.Entities.Relationships.MeasureSens;
import com.senai.Flora.Domain.Repositories.Relationships.MeasureSensRepository;
import com.senai.Flora.Infrastructure.Mapper.Relationships.MapperMeasureSens;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MeasureSensService {

    private final MeasureSensRepository repository;

    private final MapperMeasureSens mapper;

    private final EntityManager entityManager;

    public MeasureSensService(MeasureSensRepository repository, MapperMeasureSens mapper, EntityManager entityManager) {
        this.repository = repository;
        this.mapper = mapper;
        this.entityManager = entityManager;
    }

    public MeasureSensDTO registerMeasureSens (MeasureSensDTO dto) {
        MeasureSens measureSens = mapper.toEntity(dto);
        repository.save(measureSens);
        return mapper.toDTO(measureSens);
    }

    public List<MeasureSensDTO> listMeasureSens () {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public Optional<MeasureSensDTO> searchForId (Long id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    public boolean updateMeasureSens ( Long id , MeasureSensDTO dto) {
        return repository.findById(id).map(measureSens -> {

            measureSens.setSens(entityManager.getReference(Sens.class, dto.idSens()));

            measureSens.setMeasure(entityManager.getReference(Measure.class, dto.idMeasure()));

            measureSens.setAttributionDate(LocalDate.now());
            repository.save(measureSens);
            return true;

        }).orElse(false);
    }

    public boolean removeMeasureSens (Long id) {
        return repository.findById(id).map(measureSens -> {
            repository.deleteById(id);
            return true;

        }).orElse(false);
    }

}
