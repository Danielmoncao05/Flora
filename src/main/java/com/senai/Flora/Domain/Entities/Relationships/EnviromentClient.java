package com.senai.Flora.Domain.Entities.Relationships;

import com.senai.Flora.Domain.Entities.Entity.Register.enviroment.Enviroment;
import com.senai.Flora.Domain.Entities.Entity.Register.user.ClientFlora;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnviromentClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enviromentClient")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private ClientFlora clientFlora;

    @ManyToOne
    @JoinColumn(name = "id_Enviroment")
    private Enviroment enviroment;

    @Column(name = "attribution_date")
    private LocalDate attributionDate;
}
