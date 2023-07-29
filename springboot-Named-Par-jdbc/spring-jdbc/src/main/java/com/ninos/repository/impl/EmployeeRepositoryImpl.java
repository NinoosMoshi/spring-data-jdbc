package com.ninos.repository.impl;

import lombok.AllArgsConstructor;

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

import static com.ninos.query.JdbcQuery.COUNT_EMPLOYEE_QUERY;
import static com.ninos.query.JdbcQuery.DELETE_EMPLOYEE_QUERY;
import static com.ninos.query.JdbcQuery.FIND_EMPLOYEE_BY_FIRST_AND_LAST_QUERY;
import static com.ninos.query.JdbcQuery.GET_ALL_EMPLOYEES;
import static com.ninos.query.JdbcQuery.GET_EMPLOYEE_BY_ID_QUERY;
import static com.ninos.query.JdbcQuery.INSERT_INTO_EMPLOYEE_QUERY;
import static com.ninos.query.JdbcQuery.UPDATE_EMPLOYEE_QUERY;

@AllArgsConstructor
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final NamedParameterJdbcTemplate jdbc;


    @Override
    public int count() {
//        return jdbc.queryForObject(COUNT_EMPLOYEE_QUERY, Integer.class);
        return 0;
    }



    @Override
    public Employee findById(Long id) {
        return jdbc.queryForObject(GET_EMPLOYEE_BY_ID_QUERY, Map.of("id", id), new EmployeeRowMapper());
    }

    @Override
    public List<Employee> findAll() {
        return jdbc.query(GET_ALL_EMPLOYEES, new EmployeeRowMapper());
    }

    @Override
    public Employee insert(Employee employee) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = getSqlParameterSource(employee);
        jdbc.update(INSERT_INTO_EMPLOYEE_QUERY, parameters, holder);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = getSqlParameterSource(employee);
        jdbc.update(UPDATE_EMPLOYEE_QUERY, parameters, holder);
        return employee;
    }

    @Override
    public String deleteById(Long id) {
        jdbc.update(DELETE_EMPLOYEE_QUERY,Map.of("id",id));
        return "Employee is deleted Successfully at id: " + id;
    }

    @Override
    public List<Employee> findByFirstAndLast(String firstName, String lastName) {
        List<Employee> employees = jdbc.query(FIND_EMPLOYEE_BY_FIRST_AND_LAST_QUERY,
                Map.of("firstName", firstName, "lastName", lastName),
                new EmployeeRowMapper());
        return employees;
    }


    // Private Methods Section

    private SqlParameterSource getSqlParameterSource(Employee employee) {
        return new MapSqlParameterSource()
                .addValue("id", employee.getId())
                .addValue("firstName", employee.getFirstName())
                .addValue("lastName", employee.getLastName());
    }





}






