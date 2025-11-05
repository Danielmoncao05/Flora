package com.senai.Flora.Domain.Entities.Entity.Register.enviroment;


import com.senai.Flora.Domain.Entities.Relationships.EnviromentClient;
import com.senai.Flora.Domain.Entities.Relationships.EnviromentPlant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enviroment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Enviroment" , nullable = false)
    private Long id;

    @Column(name = "name_description", nullable = false)
    private String nameDescription;

    @Column(name = "observation", nullable = false)
    private String observation;

    @Column(name = "state" , nullable = false)
    private boolean state;

    @Column(name = "location" , nullable = false  )
    private LocalDateTime location;

    @OneToMany(mappedBy = "enviroment", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<EnviromentClient> clients;

    @OneToMany(mappedBy = "enviroment" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<EnviromentPlant> plants;

}
