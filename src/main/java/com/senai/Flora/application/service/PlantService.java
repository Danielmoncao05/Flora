package com.senai.Flora.application.service;

import com.senai.Flora.Infrastructure.dto.PlantDTO;
import com.senai.Flora.domain.Plant;
import com.senai.Flora.Infrastructure.repository.PlantRepository;
import com.senai.Flora.Infrastructure.mapper.MapperPlant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlantService {

    @Autowired
    private PlantRepository repo;

    @Autowired
    private MapperPlant mapper;


    public PlantDTO registerPlant (PlantDTO dto) {
        Plant plant = mapper.toEntity(dto);
        repo.save(plant);

        return mapper.toDTO(plant);
    }

    public List<PlantDTO> listPlants () {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public Optional<PlantDTO> searchForId (Long id) {
        return repo.findById(id).map(mapper::toDTO);
    }

    public boolean updatePlant (Long id , PlantDTO dto) {
        return repo.findById(id).map(plant -> {

            plant.setName(dto.name());
            plant.setState(dto.state());
            plant.setSpecialHelp(dto.specialHelp());

            repo.save(plant);

            return true;

        }).orElse(false);
    }

    public boolean removePlant (Long id) {
        return repo.findById(id).map(plant -> {
            repo.deleteById(id);
            return true;

        }).orElse(false);
    }
}
