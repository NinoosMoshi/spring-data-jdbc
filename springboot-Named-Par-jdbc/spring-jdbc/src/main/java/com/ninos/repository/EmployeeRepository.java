package com.ninos.repository;

import java.util.List;

import com.ninos.model.Employee;

public interface EmployeeRepository {

    int count();

    Employee findById(Long id);

    List<Employee> findAll();

    Employee insert(Employee employee);

    Employee update(Employee employee);

    String deleteById(Long id);

    List<Employee> findByFirstAndLast(String firstName, String lastName);

}
