package com.ninos.repository;

import java.util.List;

import com.ninos.model.Employee;

public interface EmployeeRepository {

    int count();

    Employee findById(Long id);

    List<Employee> findAll();

    int insert(Employee employee);

    int update(Employee employee);

    int delete(Long id);

}
