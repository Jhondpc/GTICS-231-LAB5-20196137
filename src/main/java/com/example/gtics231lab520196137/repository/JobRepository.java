package com.example.gtics231lab520196137.repository;

import com.example.gtics231lab520196137.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job,Integer> {
}
