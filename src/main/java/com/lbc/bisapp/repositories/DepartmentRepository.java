package com.lbc.bisapp.repositories;

import org.springframework.stereotype.Repository;
import com.lbc.bisapp.entities.Department;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
@Query("SELECT d FROM Department d WHERE d.name = :name")
    Department findByName(String name);
    
} 
