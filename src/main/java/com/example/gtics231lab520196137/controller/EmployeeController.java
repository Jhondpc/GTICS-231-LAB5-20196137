package com.example.gtics231lab520196137.controller;

import com.example.gtics231lab520196137.dto.EmployeeDto;
import com.example.gtics231lab520196137.entity.Employee;
import com.example.gtics231lab520196137.repository.DepartmentRepository;
import com.example.gtics231lab520196137.repository.EmployeeRepository;
import com.example.gtics231lab520196137.repository.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    final EmployeeRepository employeeRepository;
    final DepartmentRepository departmentRepository;
    final JobRepository jobRepository;
    public EmployeeController(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, JobRepository jobRepository){
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.jobRepository = jobRepository;
    }

    @GetMapping("/list")
    public String listarEmpleados(Model model){
        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("employeeList", employeeList);
        return "employee/list";
    }
    @PostMapping("/buscar")
    public String buscarEmpleado(@RequestParam("textoBuscar") String textoBuscar,
                                 Model model){
        List<EmployeeDto> employeeList = employeeRepository.buscarEmpleado(textoBuscar);
        model.addAttribute("employeeList",employeeList);
        return "employee/listBuscado";
    }

    @GetMapping("/edit")
    public String editarEmpleado(Model model,
                                 @RequestParam("id") int id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            model.addAttribute("employee", employee);
            return "employee/editForm";
        } else {
            return "redirect:/employee/list";
        }
    }
    @GetMapping("/delete")
    public String borrarTransportista(@RequestParam("id") int id, RedirectAttributes attr) {

        attr.addFlashAttribute("msgDelete", "Empleado borrado exitosamente");
        Optional<Employee> optShipper = employeeRepository.findById(id);
        if (optShipper.isPresent()) {
            employeeRepository.deleteById(id);
        }
        return "redirect:/employee/list";
    }
    @GetMapping("/new")
    public String nuevoEmpleadoForm(Model model) {
        model.addAttribute("listJob", jobRepository.findAll());
        model.addAttribute("listManager", employeeRepository.findAll());
        return "employee/newForm";
    }

    @PostMapping("/save")
    public String guardarProducto(@RequestParam("nombre") String nombre,
                                  @RequestParam("apellido") String apellido,
                                  @RequestParam("email") String email,
                                  @RequestParam("password") String password,
                                  @RequestParam("jobId") String jobId,
                                  @RequestParam("salary") float salary,
                                  @RequestParam("managerId") int managerId,
                                  @RequestParam("departamento") String departament, RedirectAttributes attr){
        attr.addFlashAttribute("msgNew", "Empleado creado exitosamente");
        int departmentId = departmentRepository.buscarPorNombre(departament);
        employeeRepository.guardarEmpleado(nombre, apellido, email, password, jobId, salary, managerId, departmentId);
        return "redirect:/employee/list";
    }

}
