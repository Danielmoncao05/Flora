package com.senai.Flora.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientFlora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // identificator
    private Long idClient;

    private String name;
    private Integer age;
    private String email;

    private String password; // * Eh Dani eu adicionei essa variavel que ficou faltando

}
