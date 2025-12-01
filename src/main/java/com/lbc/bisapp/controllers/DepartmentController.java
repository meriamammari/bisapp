package com.lbc.bisapp.controllers;

import org.springframework.web.bind.annotation.*;
import com.lbc.bisapp.entities.Department;
import com.lbc.bisapp.services.DepartmentService;
import lombok.AllArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/all")
    public List<Department> getAll() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("/create")
    public Department createNewDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long id) {
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping("/get/{id}")
    public Department getById(@PathVariable("id") Long id) {
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        return departmentService.deleteDepartment(id);
    }
}

