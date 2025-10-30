package com.senai.Flora.Application.Services.Entities.Register;

import com.senai.Flora.Application.DTOs.Entities.Register.PlantDTO;
import com.senai.Flora.Domain.Entities.Entity.Register.Plant.Plant;
import com.senai.Flora.Domain.Repositories.Entity.PlantRepository;
import com.senai.Flora.Infrastructure.Mapper.Entities.MapperPlant;
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

    /*----------------------------------- Associate plant category--------------------------------*/
}
