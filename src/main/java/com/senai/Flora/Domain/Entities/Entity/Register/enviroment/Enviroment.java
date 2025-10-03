package com.senai.Flora.Domain.Entities.Entity.Register.enviroment;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Long idEnviroment;

    private String nameDescription;
    private String observation;
    private boolean state;
    private LocalDateTime location;

}
