package com.senai.Flora.Domain.Entities.Relationships;


import com.senai.Flora.Domain.Entities.Entity.Register.Plant.Plant;
import com.senai.Flora.Domain.Entities.Entity.Register.enviroment.Enviroment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnviromentPlant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enviromentplant")
    private Long id_EnviromentPlant;

    @ManyToOne
    @JoinColumn(name = "id_plant")
    private Plant plant;

    @ManyToOne
    @JoinColumn(name = "id_enviroment")
    private Enviroment enviroment;


}
