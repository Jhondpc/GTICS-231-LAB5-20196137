package com.example.gtics231lab520196137.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", nullable = false)
    private int id;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "state_province")
    private String stateProvince;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
