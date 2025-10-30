package com.senai.Flora.Infrastructure.mapper;

import com.senai.Flora.Infrastructure.dto.PlantDTO;
import com.senai.Flora.domain.Plant;
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
                plant.getId(),
                plant.getName(),
                plant.isState(),
                plant.getSpecialHelp()
        );
    }
}
