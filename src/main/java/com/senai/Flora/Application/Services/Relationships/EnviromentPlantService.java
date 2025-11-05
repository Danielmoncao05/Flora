package com.senai.Flora.Application.Services.Relationships;

import com.senai.Flora.Application.DTOs.Relationships.EnviromentPlantDTO;
import com.senai.Flora.Domain.Entities.Entity.Register.Plant.Plant;
import com.senai.Flora.Domain.Entities.Entity.Register.enviroment.Enviroment;
import com.senai.Flora.Domain.Entities.Relationships.EnviromentPlant;
import com.senai.Flora.Domain.Repositories.Relationships.EnviromentPlantRepository;
import com.senai.Flora.Infrastructure.Mapper.Relationships.MapperEnviromentPlant;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnviromentPlantService {

    private final EnviromentPlantRepository repository;

    private final MapperEnviromentPlant mapper;

    private final EntityManager entityManager;

    public EnviromentPlantService(EnviromentPlantRepository repository, MapperEnviromentPlant mapper, EntityManager entityManager) {
        this.repository = repository;
        this.mapper = mapper;
        this.entityManager = entityManager;
    }

    public EnviromentPlantDTO registerEnviromentPlant (EnviromentPlantDTO dto) {
        EnviromentPlant enviromentPlant = mapper.toEntity(dto);
        repository.save(enviromentPlant);

        return mapper.toDTO(enviromentPlant);
    }

    public List<EnviromentPlantDTO> listEnviromentPlant () {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public Optional<EnviromentPlantDTO> searchForId (Long id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    public boolean updateEnviromentPlant (Long id , EnviromentPlantDTO dto) {
        return repository.findById(id).map(enviromentPlant -> {
            enviromentPlant.setPlant(entityManager.getReference(Plant.class, dto.idPlant()));
            enviromentPlant.setEnviroment(entityManager.getReference(Enviroment.class, dto.idEnviroment()));

            return true;

        }).orElse(false);
    }

    public boolean removeEnviromentPlant (Long id) {
        return repository.findById(id).map(enviromentPlant -> {
            repository.deleteById(id);
            return true;

        }).orElse(false);
    }

}
