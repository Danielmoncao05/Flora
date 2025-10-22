package com.senai.Flora.Domain.Entities.Relationships;

import com.senai.Flora.Domain.Entities.Entity.IoT.Measure;
import com.senai.Flora.Domain.Entities.Entity.IoT.Sens;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeasureSens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_measuresens" , nullable = false)
    private Long id_MeasureSens;

    @ManyToOne
    @JoinColumn(name = "id_sens" , nullable = false)
    private Sens sens;

    // verificar
    @ManyToOne
    @JoinColumn(name = "id_measure" , nullable = false)
    private Measure measure;


}
