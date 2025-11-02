package com.lbc.bisapp.services;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import com.lbc.bisapp.entities.SubDepartment;
import com.lbc.bisapp.repositories.SubDepartmentRepository;

@Service
@AllArgsConstructor
public class SubDepartmentService {

    private final SubDepartmentRepository subDepartmentRepository;

    public SubDepartment createSubDepartment(SubDepartment subDepartment) {
        return subDepartmentRepository.save(subDepartment);
    }

    public List<SubDepartment> getAllSubDepartments() {
        return subDepartmentRepository.findAll();
    }

    public SubDepartment getSubDepartmentById(Long id) {
        return subDepartmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SubDepartment not found"));
    }

    public SubDepartment updateSubDepartment(Long id, SubDepartment subDepartment) {
        SubDepartment existing = subDepartmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SubDepartment not found"));
        existing.setName(subDepartment.getName());
        existing.setDepartment(subDepartment.getDepartment());
        return subDepartmentRepository.save(existing);
    }

    public void deleteSubDepartment(Long id) {
        SubDepartment existing = subDepartmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SubDepartment not found"));
        subDepartmentRepository.delete(existing);
    }

    public List<SubDepartment> findSubDepartmentByDepartmentName(String departmentName) {
        return subDepartmentRepository.findSubDepartmentByDepartmentName(departmentName);
    }
}
