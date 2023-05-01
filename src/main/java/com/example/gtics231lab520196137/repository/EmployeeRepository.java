package com.example.gtics231lab520196137.repository;

import com.example.gtics231lab520196137.dto.EmployeeDto;
import com.example.gtics231lab520196137.dto.SalarioDto;
import com.example.gtics231lab520196137.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(nativeQuery = true, value = "select e.employee_id as id, e.first_name as nombre, e.last_name as apellido, e.email as email, e.password as password,\n" +
            "\t   e.phone_number as telefono, e.hire_date as hireDate, j.job_title as job, e.salary as salary,\n" +
            "       e.commission_pct as commissionPct, e.manager_id as managerId, d.department_name as department, l.city as ciudad, e.enabled as enabled\n" +
            "\t\t\n" +
            "from employees e\n" +
            "inner join jobs j on (e.job_id=j.job_id)\n" +
            "inner join departments d on (e.department_id=d.department_id)\n" +
            "inner join locations l on (d.location_id=l.location_id)\n" +
            "where e.first_name=?1 or e.last_name=?1 or j.job_title=?1 or l.city=?1")
    List<EmployeeDto> buscarEmpleado(String textoBuscar);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO `hr`.`employees` (`first_name`, `last_name`, `email`, `password`, `hire_date`, `job_id`, `salary`, `manager_id`, `department_id`) VALUES (?1, ?2, ?3, ?4, NOW(), ?5, ?6, ?7, ?8)")
    void guardarEmpleado(String nombre, String apellido, String email, String password, String jobId, float salary, int managerId, int departmentId);

    @Query(nativeQuery = true, value = "select j.job_title as puesto, j.max_salary as salarioMaximo, j.min_salary as salarioMinimo, SUM(e.salary) as salarioTotal, AVG(e.salary) as salarioPromedio\n" +
            "from jobs j\n" +
            "inner join employees e on (j.job_id=e.job_id)\n" +
            "group by e.job_id")
    List<SalarioDto> listarSalarios();
}

