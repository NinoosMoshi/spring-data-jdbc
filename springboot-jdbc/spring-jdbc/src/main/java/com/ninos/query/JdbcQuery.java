package com.ninos.query;

public class JdbcQuery {

    public static final String COUNT_EMPLOYEE_QUERY = "select count(*) from employees";
    public static final String GET_EMPLOYEE_BY_ID_QUERY = "select * from employees where id = ?";
    public static final String GET_ALL_EMPLOYEES = "select * from employees";
    public static final String INSERT_INTO_EMPLOYEE_QUERY = "insert into employees(id, first_name, last_name) values (?,?,?)";
    public static final String UPDATE_EMPLOYEE_QUERY = "update employees set first_name=?, last_name=?";
    public static final String DELETE_EMPLOYEE_QUERY = "delete from employees where id=?";

}
