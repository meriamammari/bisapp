package com.lbc.bisapp.services;
import org.springframework.stereotype.Service;

import com.lbc.bisapp.iservice.IDepartmentService;

import lombok.AllArgsConstructor;

import com.lbc.bisapp.entities.Department;
import com.lbc.bisapp.repositories.DepartmentRepository;

@Service
@AllArgsConstructor
public class DepartmentService  implements IDepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public java.util.List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not Found Department)"));
    }


    @Override
    public Department updateDepartment(Long id, Department department) {
        Department existingDepartment = departmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not Found Department)"));
        if (existingDepartment != null) {
            existingDepartment.setName(department.getName());
           
            return departmentRepository.save(existingDepartment);
        }
        return null;
    }
    @Override
    public String deleteDepartment(Long id) {
        Department dept = departmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not Found Department)"));
        departmentRepository.delete(dept);
        return "Deleted Successfully";
    }


    
}
