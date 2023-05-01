package com.example.gtics231lab520196137.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private int id;
    @Column(name = "first_name")
    private String nombre;
    @Column(name = "last_name", nullable = false)
    private String apellido;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone_number")
    private String phone;
    @Column(name = "hire_date", nullable = false)
    private Date hireDate;
    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;
    @Column(name = "salary")
    private float salary;
    @Column(name = "commission_pct")
    private BigDecimal commissionPct;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @Column(name = "enabled")
    private int enabled;
}
