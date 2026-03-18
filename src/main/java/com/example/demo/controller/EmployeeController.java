package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employees")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/employees/sort")
    public String getData(@RequestParam("sortBy") String sortBy) {
        return "Sorting by " + sortBy;
    }

    @GetMapping(path = "/employees/{id}")
    public EmployeeDTO getEmployee(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping(path = "/employees")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return  employeeService.createEmployee(employeeDTO);
    }



//    ?sortBy=age
}


