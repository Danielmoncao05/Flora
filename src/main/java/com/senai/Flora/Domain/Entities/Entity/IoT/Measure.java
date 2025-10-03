package com.senai.Flora.Domain.Entities.Entity.IoT;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Measure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Measure" ,nullable = false)
    private Long id_measure;

    @Column(name = "measure_Name" ,nullable = false)
    private String measure_name;

    @Column(name = "measure_Default" ,nullable = false)
    private double measure_default;
}
