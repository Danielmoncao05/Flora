package com.senai.Flora.Domain.Entities.Entity.Register.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientFlora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // identificator
    @Column(name = "id_Client", nullable = false)
    private Long idClient;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "email" , nullable = false)
    private String email;

}
