package com.senai.Flora.Domain.Entities.Entity;

import com.senai.Flora.Domain.Entities.Entity.IoT.Sens;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notification" , nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_sens", nullable = false)
    private Sens sens;

    @Column(name = "attribution_date")
    private LocalDate attributionDate;
}
