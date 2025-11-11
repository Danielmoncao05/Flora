package com.senai.Flora.domain;


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
    private Long idEnviroment;

    private String nameDescription;
    private String observation;
    private boolean state;
    private String location;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClientFlora owner; // * pra criar a coluna cliente_id na tabela enviroment

}
