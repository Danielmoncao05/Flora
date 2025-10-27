package com.senai.Flora.Domain.Entities.Entity.Register.user;

import com.senai.Flora.Domain.Entities.Entity.IoT.Sens;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Notification" , nullable = false)
    private Long id_Notification;

    @ManyToOne
    @JoinColumn(name = "id_sens", nullable = false)
    private Sens sens;
}
