package com.senai.Flora.Application.Services.Relationships;

import com.senai.Flora.Application.DTOs.Relationships.EnviromentPlantDTO;
import com.senai.Flora.Domain.Entities.Relationships.EnviromentPlant;
import com.senai.Flora.Domain.Repositories.Relationships.EnviromentPlantRepository;
import com.senai.Flora.Infrastructure.Mapper.Relationships.MapperEnviromentPlant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnviromentPlantService {

    private final EnviromentPlantRepository repository;

    private final MapperEnviromentPlant mapper;

    public EnviromentPlantService(EnviromentPlantRepository repository, MapperEnviromentPlant mapper) {
        this.repository = repository;
        this.mapper = mapper;
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
            enviromentPlant.getPlant().setId_Plant(dto.id_Plant());
            enviromentPlant.getEnviroment().setIdEnviroment(dto.id_Enviroment());

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
