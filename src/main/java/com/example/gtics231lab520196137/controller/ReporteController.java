package com.example.gtics231lab520196137.controller;

import com.example.gtics231lab520196137.dto.SalarioDto;
import com.example.gtics231lab520196137.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/reporte")
public class ReporteController {

    final EmployeeRepository employeeRepository;

    public ReporteController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @GetMapping("/dashboard")
    public String index(){
        return "reporte/reportesDashboards";
    }
    @GetMapping("/salario")
    public String salario(Model model){
        List<SalarioDto> salarioDtoList = employeeRepository.listarSalarios();
        model.addAttribute("salarioList",salarioDtoList);
        return "reporte/sueldos";
    }
    @GetMapping("/tentativaAumento")
    public String tentativaAumento(Model model){
        return "reporte/tentativaAumento";
    }
}
