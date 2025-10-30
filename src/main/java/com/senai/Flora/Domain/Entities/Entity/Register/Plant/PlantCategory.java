package com.senai.Flora.Domain.Entities.Entity.Register.Plant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_CategoryPlant", nullable = false)
    private Long id_PlantCategory;

    @Column(name = "implementation_date" , nullable = false)
    private LocalDate implantationDate;

    @Column(name = "plant_type", nullable = false)
    private String type;

    @Column(name = "observation" , nullable = false)
    private String observation;

    /*---------------------------Relation Plants--------------------------------------*/
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Plant> plants;
}
