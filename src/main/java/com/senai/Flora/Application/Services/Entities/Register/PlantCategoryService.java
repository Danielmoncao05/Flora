package com.senai.Flora.Application.Services.Entities.Register;

import com.senai.Flora.Application.DTOs.Entities.Register.PlantCategoryDTO;
import com.senai.Flora.Domain.Entities.Entity.Register.Plant.PlantCategory;
import com.senai.Flora.Domain.Repositories.Entity.PlantCategoryRepository;
import com.senai.Flora.Infrastructure.Mapper.Entities.MapperPlantCategory;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlantCategoryService {

    private final PlantCategoryRepository repository;

    private final MapperPlantCategory mapper;

    public PlantCategoryService(PlantCategoryRepository repository, MapperPlantCategory mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public PlantCategoryDTO createPlantCategory (PlantCategoryDTO dto) {
        PlantCategory plantCategory = mapper.toEntity(dto);
        repository.save(plantCategory);
        return mapper.toDTO(plantCategory);
    }

    public List<PlantCategoryDTO> listPlantCategory () {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public Optional<PlantCategoryDTO> searchForId (Long id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    @Transactional
    public boolean updatePlantCategory(Long id , PlantCategoryDTO dto) {
        return repository.findById(id).map(plantCategory -> {
            plantCategory.setImplantationDate(LocalDate.now());
            plantCategory.setType(dto.type());
            plantCategory.setObservation(dto.observation());

            repository.save(plantCategory);
            return true;

        }).orElse(false);
    }

    public boolean removePlantCategory (Long id) {
        return repository.findById(id).map(plantCategory -> {
            repository.deleteById(id);
            return true;

        }).orElse(false);
    }

    //-------------------------------------- List of plants -------------------------------------//


}
