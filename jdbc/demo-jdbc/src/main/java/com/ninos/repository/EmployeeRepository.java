package com.ninos.repository;

import java.util.List;

import com.ninos.model.Employee;

public interface EmployeeRepository<T extends Employee> {

    T findById(Long id);

    T saveEmployee(T employee);

    T updateEmployee(T employee);

    String deleteById(Long id);

    List<T> getAllEmployee();

}
