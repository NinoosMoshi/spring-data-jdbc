package com.ninos.controller;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninos.model.Employee;
import com.ninos.repository.EmployeeRepository;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeRepository<Employee> employeeRepository;


    @PostMapping("/save")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.saveEmployee(employee);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeRepository.updateEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeRepository.findById(id);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
        return employeeRepository.getAllEmployee();
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return employeeRepository.deleteById(id);
    }



}
