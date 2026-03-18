package com.example.demo.services;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    // Dependency Injection don't use autowire here
    final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(e -> new EmployeeDTO(e.getId(), e.getFirstName(), e.getLastName(), e.getIsActive()))
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(int id) {
     EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
      return new EmployeeDTO(employeeEntity.getId(), employeeEntity.getFirstName(), employeeEntity.getLastName(), employeeEntity.getIsActive());
    }
    
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity(
            employeeDTO.getId(),
            employeeDTO.getFirstName(),
            employeeDTO.getLastName(),
            employeeDTO.getIsActive()
        );
        EmployeeEntity savedEntity = employeeRepository.save(employeeEntity);
        return new EmployeeDTO(
            savedEntity.getId(),
            savedEntity.getFirstName(),
            savedEntity.getLastName(),
            savedEntity.getIsActive()
        );
    }
}
