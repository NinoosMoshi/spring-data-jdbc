package com.ninos.query;

public class JdbcQuery {

    public static final String COUNT_EMPLOYEE_QUERY = "select count(*) from employees";
    public static final String GET_EMPLOYEE_BY_ID_QUERY = "select * from employees where id =:id ";
    public static final String GET_ALL_EMPLOYEES = "select * from employees";
    public static final String INSERT_INTO_EMPLOYEE_QUERY = "insert into employees(id, first_name, last_name) values (:id,:firstName,:lastName)";
    public static final String UPDATE_EMPLOYEE_QUERY = "update employees set first_name=:firstName, last_name=:lastName where id=:id";
    public static final String DELETE_EMPLOYEE_QUERY = "delete from employees where id=:id";
    public static final String FIND_EMPLOYEE_BY_FIRST_AND_LAST_QUERY = "select * from employees where first_name=:first_name and last_name=:last_name";




}
