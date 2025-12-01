package com.lbc.bisapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import com.lbc.bisapp.entities.SubDepartment;
import com.lbc.bisapp.services.SubDepartmentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/subDepartment")
@AllArgsConstructor
public class SubDepartmentController {

    private final SubDepartmentService subDepartmentService;

    // ✅ Correction : précise les formats supportés
    @PostMapping(
        value = "/create",
        consumes = "application/json",
        produces = "application/json"
    )
    public ResponseEntity<SubDepartment> createSubDepartment(@Valid @RequestBody SubDepartment subDepartment) {
        SubDepartment created = subDepartmentService.createSubDepartment(subDepartment);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping(
        value = "/update/{id}",
        consumes = "application/json",
        produces = "application/json"
    )
    public ResponseEntity<SubDepartment> updateSubDepartment(@Valid @RequestBody SubDepartment subDepartment,
                                                             @PathVariable("id") Long id) {
        SubDepartment updated = subDepartmentService.updateSubDepartment(id, subDepartment);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SubDepartment>> getAll() {
        List<SubDepartment> list = subDepartmentService.getAllSubDepartments();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SubDepartment> getById(@PathVariable("id") Long id) {
        SubDepartment subDepartment = subDepartmentService.getSubDepartmentById(id);
        return ResponseEntity.ok(subDepartment);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSubDepartment(@PathVariable("id") Long id) {
        subDepartmentService.deleteSubDepartment(id);
        return ResponseEntity.ok("SubDepartment deleted successfully");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @GetMapping("/filter/{departmentName}")
    public ResponseEntity<List<SubDepartment>> findByDepartmentName(@PathVariable String departmentName) {
        List<SubDepartment> subDepartments = subDepartmentService.findSubDepartmentByDepartmentName(departmentName);
        return ResponseEntity.ok(subDepartments);
    }
}

