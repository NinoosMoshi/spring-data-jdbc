package com.ninos.controller;

import lombok.RequiredArgsConstructor;

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

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping("/count")
    public int countEmployee() {
        return employeeRepository.count();
    }


    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeRepository.findById(id);
    }


    @GetMapping("/all")
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }


    @PostMapping("/save")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.insert(employee);
    }


    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeRepository.update(employee);
    }


    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return employeeRepository.deleteById(id);
    }


}