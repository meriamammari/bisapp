package com.lbc.bisapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom ne peut pas être vide")
    private String name;

    private int age;

    @Email(message = "Email invalide")
    @Column(unique = true)
    private String email;

    //  Relation avec Department
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    //  Nouvelle relation avec SubDepartment
    @ManyToOne
    @JoinColumn(name = "sub_department_id")
    private SubDepartment subDepartment;
}
