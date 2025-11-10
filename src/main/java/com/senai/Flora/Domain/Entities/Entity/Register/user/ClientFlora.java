package com.senai.Flora.Domain.Entities.Entity.Register.user;

import com.senai.Flora.Domain.Entities.Entity.Abstract.User;
import com.senai.Flora.Domain.Entities.Relationships.EnviromentClient;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "id") // foreign key define with primary
public class ClientFlora {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // identificator
//    @Column(name = "id_client", nullable = false)
//    private Long id;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Column(name = "age", nullable = false)
//    private Integer age;
//
//    @Column(name = "email" , nullable = false)
//    private String email;

    @OneToMany(mappedBy = "clientFlora")
    private List<EnviromentClient> enviroments;
}
