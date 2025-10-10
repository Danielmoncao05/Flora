package com.senai.Flora.Infrastructure.Mapper;

import com.senai.Flora.Application.DTOs.Entities.Register.PlantDTO;
import com.senai.Flora.Domain.Entities.Entity.Register.Plant.Plant;
import org.springframework.stereotype.Component;

@Component
public class MapperPlant {

    public Plant toEntity (PlantDTO dto) {
        if (dto == null) return null;
        Plant plant = new Plant();
        plant.setName(dto.name());
        plant.setState(dto.state());
        plant.setSpecialHelp(dto.specialHelp());

        return plant;
    }

    public PlantDTO toDTO (Plant plant) {
        if (plant == null) return null;
        return new PlantDTO(
                plant.getId_Plant(),
                plant.getName(),
                plant.isState(),
                plant.getSpecialHelp()
        );
    }
}
