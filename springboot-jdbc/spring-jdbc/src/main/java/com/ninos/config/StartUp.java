package com.ninos.config;

import lombok.AllArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ninos.model.Employee;
import com.ninos.repository.EmployeeRepository;

@AllArgsConstructor
@Component
public class StartUp implements CommandLineRunner {

    private final JdbcTemplate jdbc;
    public final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {

        jdbc.execute("DROP TABLE IF EXISTS employees");
        jdbc.execute("CREATE TABLE employees(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        if (employeeRepository.count() == 0){
            employeeRepository.insert(new Employee(1L,"ninos", "moshi"));
            employeeRepository.insert(new Employee(2L,"nahrain", "moshi"));
            employeeRepository.insert(new Employee(3L,"matthew", "moshi"));
            employeeRepository.insert(new Employee(4L,"daniel", "moshi"));
        }


    }
}
