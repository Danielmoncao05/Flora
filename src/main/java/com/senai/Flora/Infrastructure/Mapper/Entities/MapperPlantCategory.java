    package com.senai.Flora.Infrastructure.Mapper.Entities;

    import com.senai.Flora.Application.DTOs.Entities.Register.PlantCategoryDTO;
    import com.senai.Flora.Domain.Entities.Entity.Register.Plant.Plant;
    import com.senai.Flora.Domain.Entities.Entity.Register.Plant.PlantCategory;
    import jakarta.persistence.EntityManager;
    import org.springframework.stereotype.Component;

    import java.time.LocalDate;
    import java.util.ArrayList;
    import java.util.stream.Collectors;

    @Component
    public class MapperPlantCategory {

        private final EntityManager entityManager;

        public MapperPlantCategory(EntityManager entityManager) {
            this.entityManager = entityManager;
        }

        public PlantCategory toEntity (PlantCategoryDTO dto) {
            if (dto == null) return null;
            PlantCategory plantCategory =new PlantCategory();

            plantCategory.setImplantationDate(LocalDate.now());
            plantCategory.setType(dto.type());
            plantCategory.setObservation(dto.observation());

            //Understand the flow for addicionate a existent entity on a new arraylist
            plantCategory.setPlants(new ArrayList<>());

            // associate the id plant existent in a new entity plant
            Plant plant = entityManager.getReference(Plant.class, dto.id_Plant());
            //add in arraylist created
            plantCategory.getPlants().add(plant);


           // plantCategory.setPlants(entityManager.getReference(Plant.class, dto.id_Plant())); // identify interference error

    //        Plant plant = new Plant();
    //        plant.setId_Plant(dto.id_Plant());
    //        plantCategory.setPlants(plant);

            return plantCategory;
        }

        public PlantCategoryDTO toDTO (PlantCategory plantCategory) {
            return new PlantCategoryDTO(
                    plantCategory.getId_PlantCategory(),
                    plantCategory.getImplantationDate(),
                    plantCategory.getType(),
                    plantCategory.getObservation(),
                    plantCategory.getPlants().stream().map(Plant::getId_Plant).collect(Collectors.toList())
            );
        }
    }
