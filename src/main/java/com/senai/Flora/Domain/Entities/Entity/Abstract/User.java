package com.senai.Flora.Domain.Entities.Entity.Abstract;


import com.senai.Flora.Domain.Entities.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id" , nullable = false)
//    private Long id;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Column(name = "age", nullable = false)
//    private Integer age;
//
//    @Column(name = "email")
//    private String email;
//
//    private Boolean status;
//
//    protected Role role;
}
