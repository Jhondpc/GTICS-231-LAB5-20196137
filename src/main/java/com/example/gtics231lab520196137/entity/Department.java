package com.example.gtics231lab520196137.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", nullable = false)
    private int id;
    @Column(name = "department_name")
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
