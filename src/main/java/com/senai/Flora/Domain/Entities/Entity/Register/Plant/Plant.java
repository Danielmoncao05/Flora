package com.senai.Flora.Domain.Entities.Entity.Register.Plant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Plant")
    private Long id_Plant;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "state" , nullable = false)
    private boolean state;

    @Column(name = "special_Help", nullable = false)
    private String specialHelp;
}
