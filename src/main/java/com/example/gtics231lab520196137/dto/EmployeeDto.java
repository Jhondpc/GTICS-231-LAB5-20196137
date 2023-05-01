package com.example.gtics231lab520196137.dto;

import java.math.BigDecimal;
import java.util.Date;

public interface EmployeeDto {
    int getId();
    String getNombre();
    String getApellido();
    String getEmail();
    String getPassword();
    String getTelefono();
    Date getHireDate();
    String getJob();
    BigDecimal getSalary();
    BigDecimal getCommissionPct();
    int getManagerId();
    String getDepartment();
    String getCiudad();
    int getEnabled();




}
