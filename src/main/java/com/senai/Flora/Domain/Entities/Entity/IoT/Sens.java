package com.senai.Flora.Domain.Entities.Entity.IoT;

import com.senai.Flora.Domain.Entities.Relationships.MeasureSens;
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
public class Sens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Sens" , nullable = false)
    private Long id_Sens;

    @Column(name = "type" , nullable = false)
    private String type;

    @Column(name = "value_Sens" , nullable = false)
    private Integer value_sens;

    @Column(name = "sens_Name" , nullable = false)
    private String sens_name;

    @Column(name = "attribution_Date" , nullable = false)
    private LocalDateTime attribution_date;

    @OneToMany(mappedBy = "sens" , cascade = CascadeType.ALL)
    private List<MeasureSens> measures;

}
