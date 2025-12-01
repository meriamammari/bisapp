package com.lbc.bisapp.iservice;
import java.util.List;
import com.lbc.bisapp.entities.Department;

public interface IDepartmentService {
    Department createDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    Department updateDepartment(Long id, Department department);
    String deleteDepartment(Long id);
    
}
