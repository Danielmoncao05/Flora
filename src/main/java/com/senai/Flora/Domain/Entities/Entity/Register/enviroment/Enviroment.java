package com.senai.Flora.Domain.Entities.Entity.Register.enviroment;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enviroment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Enviroment" , nullable = false)
    private Long idEnviroment;

    @Column(name = "name_Description", nullable = false)
    private String nameDescription;

    @Column(name = "observation", nullable = false)
    private String observation;

    @Column(name = "state" , nullable = false)
    private boolean state;

    @Column(name = "location" , nullable = false)
    private LocalDateTime location;

}
