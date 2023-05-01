package com.example.gtics231lab520196137.repository;

import com.example.gtics231lab520196137.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    @Query(nativeQuery = true, value = "select department_id  from departments where department_name=?1")
    int buscarPorNombre(String nombre);
}
