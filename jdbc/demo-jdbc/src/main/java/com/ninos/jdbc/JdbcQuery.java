package com.ninos.jdbc;

public class JdbcQuery {

    public static final String INSERT_EMPLOYEE_QUERY = "INSERT INTO Employees (first_name, last_name) VALUES (:firstName, :lastName)";
    public static final String UPDATE_EMPLOYEE_QUERY= "UPDATE employees SET first_name =:firstName , last_name =:lastName  WHERE id = :id";
    public static final String GET_EMPLOYEE_BY_ID_QUERY= "SELECT * FROM Employees WHERE id =:id";
    public static final String DELETE_EMPLOYEE_BY_ID_QUERY= "DELETE FROM Employees WHERE id =:id";
    public static final String GET_ALL_EMPLOYEE_QUERY= "SELECT * FROM employees";


}
