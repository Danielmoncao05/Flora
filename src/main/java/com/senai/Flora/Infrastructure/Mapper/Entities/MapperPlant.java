package com.senai.Flora.Infrastructure.Mapper.Entities;

import com.senai.Flora.Application.DTOs.Entities.Register.PlantDTO;
import com.senai.Flora.Domain.Entities.Entity.Register.Plant.Plant;
import com.senai.Flora.Domain.Entities.Entity.Register.Plant.PlantCategory;
import org.springframework.stereotype.Component;

@Component
public class MapperPlant {

    public Plant toEntity (PlantDTO dto) {
        if (dto == null) return null;
        Plant plant = new Plant();
        plant.setName(dto.name());
        plant.setState(dto.state());
        plant.setSpecialHelp(dto.specialHelp());

        // ghost entity
//        PlantCategory plantCategory = new PlantCategory();
//        if (dto.id_PlantCategory() != null){
//            plantCategory.setId_PlantCategory(dto.id_PlantCategory());
//        }
//        plant.setCategory(plantCategory);
        plant.setCategory(null);



        return plant;
    }

    public PlantDTO toDTO (Plant plant) {
        if (plant == null) return null;
        return new PlantDTO(
                plant.getId_Plant(),
                plant.getName(),
                plant.isState(),
                plant.getSpecialHelp(),
                plant.getCategory() != null ? plant.getCategory().getId_PlantCategory() : null
        );
    }
}
