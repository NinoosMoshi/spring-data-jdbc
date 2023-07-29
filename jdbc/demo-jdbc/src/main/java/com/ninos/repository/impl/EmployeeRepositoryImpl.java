package com.ninos.repository.impl;

import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ninos.model.Employee;
import com.ninos.repository.EmployeeRepository;
import com.ninos.rowmapper.EmployeeRowMapper;

import static com.ninos.jdbc.JdbcQuery.DELETE_EMPLOYEE_BY_ID_QUERY;
import static com.ninos.jdbc.JdbcQuery.GET_ALL_EMPLOYEE_QUERY;
import static com.ninos.jdbc.JdbcQuery.GET_EMPLOYEE_BY_ID_QUERY;
import static com.ninos.jdbc.JdbcQuery.INSERT_EMPLOYEE_QUERY;
import static com.ninos.jdbc.JdbcQuery.UPDATE_EMPLOYEE_QUERY;

@AllArgsConstructor
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository<Employee> {

//    private final JdbcTemplate jdbc;
    private final NamedParameterJdbcTemplate jdbc;


    @Override
    public Employee findById(Long id) {
        return jdbc.queryForObject(GET_EMPLOYEE_BY_ID_QUERY,Map.of("id", id) ,new EmployeeRowMapper());
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = getSqlParameterSource(employee);
        jdbc.update(INSERT_EMPLOYEE_QUERY, parameters, holder);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = getSqlParameterSource(employee);
        jdbc.update(UPDATE_EMPLOYEE_QUERY, parameters, holder);
        return employee;
    }

    @Override
    public String deleteById(Long id) {
        jdbc.update(DELETE_EMPLOYEE_BY_ID_QUERY,Map.of("id",id));
        return "Employee is deleted Successfully at id: " + id;
    }


    @Override
    public List<Employee> getAllEmployee() {
        return jdbc.query(GET_ALL_EMPLOYEE_QUERY, new EmployeeRowMapper());
    }




    // Private Methods Section

    private SqlParameterSource getSqlParameterSource(Employee employee) {
        return new MapSqlParameterSource()
                .addValue("firstName", employee.getFirstName())
                .addValue("lastName", employee.getLastName());
    }







}
