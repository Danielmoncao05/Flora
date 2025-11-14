package com.senai.Flora.Domain.Entities.Entity.IoT;

import com.senai.Flora.Domain.Entities.Entity.Notification;
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
    private Long id;

    @Column(name = "type" , nullable = false)
    private String type;

    @Column(name = "value_Sens" , nullable = false)
    private Integer valueSens;

    @Column(name = "sens_Name" , nullable = false)
    private String sensName;

    @Column(name = "attribution_Date" , nullable = false)
    private LocalDateTime attributionDate;

    /*----------- -------------Relation Measures------------------------------*/
    @OneToMany(mappedBy = "sens" , cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "measures_id")
    private List<MeasureSens> measureSens;

    /*---------------------------Relation Notification-----------------------*/
    @OneToMany(mappedBy = "sens" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications;
}
