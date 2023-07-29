package com.ninos.repository.impl;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ninos.model.Employee;
import com.ninos.repository.EmployeeRepository;
import com.ninos.rowmapper.EmployeeRowMapper;

import static com.ninos.query.JdbcQuery.COUNT_EMPLOYEE_QUERY;
import static com.ninos.query.JdbcQuery.DELETE_EMPLOYEE_QUERY;
import static com.ninos.query.JdbcQuery.GET_ALL_EMPLOYEES;
import static com.ninos.query.JdbcQuery.GET_EMPLOYEE_BY_ID_QUERY;
import static com.ninos.query.JdbcQuery.INSERT_INTO_EMPLOYEE_QUERY;
import static com.ninos.query.JdbcQuery.UPDATE_EMPLOYEE_QUERY;

@AllArgsConstructor
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JdbcTemplate jdbc;


    @Override
    public int count() {
        return jdbc.queryForObject(COUNT_EMPLOYEE_QUERY, Integer.class);
    }

    @Override
    public Employee findById(Long id) {
        return jdbc.queryForObject(GET_EMPLOYEE_BY_ID_QUERY, new Object[] {id}, new EmployeeRowMapper());
    }

    @Override
    public List<Employee> findAll() {
        return jdbc.query(GET_ALL_EMPLOYEES, new EmployeeRowMapper());
    }

    @Override
    public int insert(Employee employee) {
        return jdbc.update(INSERT_INTO_EMPLOYEE_QUERY, new Object[] {employee.getId(), employee.getFirstName(), employee.getLastName()});
    }

    @Override
    public int update(Employee employee) {
        return jdbc.update(UPDATE_EMPLOYEE_QUERY, new Object[] {employee.getFirstName(), employee.getLastName()});
    }

    @Override
    public int delete(Long id) {
        return jdbc.update(DELETE_EMPLOYEE_QUERY, new Object[] {id});
    }


    // Private Methods Section

    private SqlParameterSource getSqlParameterSource(Employee employee) {
        return new MapSqlParameterSource()
                .addValue("firstName", employee.getFirstName())
                .addValue("lastName", employee.getLastName());
    }





}






