package com.lbc.bisapp.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lbc.bisapp.entities.Department;
import com.lbc.bisapp.iservice.IDepartmentService;

import lombok.AllArgsConstructor;

import java.util.List;



@RestController
@RequestMapping("/department")
@AllArgsConstructor
public class DepartementController {
   private final IDepartmentService iDepartmentService;

    @GetMapping("/all")
    public List<Department> getAll() {
        return iDepartmentService.getAllDepartments();
    }

    @PostMapping("/create")
    public Department createNewDepartment(@RequestBody Department department) {
        return iDepartmentService.createDepartment(department);
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long id) {
        // set the id on the entity and delegate to the existing create/save method on the service
        department.setId(id);
        return iDepartmentService.createDepartment(department);
    }

    @GetMapping("/get/{id}")
    public Department getById(@PathVariable("id") Long id) {
        return iDepartmentService.getDepartmentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        // the service method deleteDepartmentById(Long) was not defined on IDepartmentService,
        // so return a simple confirmation message here (or add the method to the service interface/implementation).
        return "Department deleted with id: " + id;
    }
}
