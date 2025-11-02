package com.lbc.bisapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lbc.bisapp.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
