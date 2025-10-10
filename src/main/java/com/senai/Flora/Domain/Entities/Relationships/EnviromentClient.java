package com.senai.Flora.Domain.Entities.Relationships;

import com.senai.Flora.Domain.Entities.Entity.Register.enviroment.Enviroment;
import com.senai.Flora.Domain.Entities.Entity.Register.user.ClientFlora;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnviromentClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enviromentClient")
    private Long id_enviromentClient;

    @ManyToOne
    @JoinColumn(name = "id_client_flora")
    private ClientFlora clientFlora;

    @ManyToOne
    @JoinColumn(name = "id_enviroment")
    private Enviroment enviroment;
}
