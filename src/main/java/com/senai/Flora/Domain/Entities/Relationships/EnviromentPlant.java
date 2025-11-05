package com.senai.Flora.Domain.Entities.Relationships;


import com.senai.Flora.Domain.Entities.Entity.Register.Plant.Plant;
import com.senai.Flora.Domain.Entities.Entity.Register.enviroment.Enviroment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnviromentPlant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enviromentplant")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_plant")
    private Plant plant;

    @ManyToOne
    @JoinColumn(name = "id_Enviroment")
    private Enviroment enviroment;

    @Column(name = "attribution_date")
    private LocalDate attributionDate;


}
