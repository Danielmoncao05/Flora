package com.senai.Flora.Domain.Entities.Entity.Register.Plant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_CategoryPlant", nullable = false)
    private Long id_PlantCategory;

    @Column(name = "dataImplantacao" , nullable = false)
    private LocalDate dataImplantacao;
}
