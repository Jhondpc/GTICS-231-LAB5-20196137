package com.example.gtics231lab520196137.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private String id;
    @Column(name = "country_name")
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
