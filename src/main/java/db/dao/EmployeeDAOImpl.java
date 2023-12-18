package db.dao;

import db.DBUtils;
import entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{
    Connection connection = DBUtils.getConnection();
    @Override
    public void add(Employee employee) throws SQLException {
        String sql = "INSERT INTO employee(first_name,last_name, role) values(?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3,employee.getRole());
            ps.executeUpdate();
        }

    }

    @Override
    public Employee getById(Long id) throws SQLException {
        Employee employee = null;
        String sql = "SELECT * FROM employee WHERE id=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1,id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setRole(resultSet.getString("role"));
            }

        }
        return employee;
    }

    @Override
    public void update(Employee employee) throws SQLException {
        String sql = "UPDATE employee SET first_name=?,last_name=?, role =? WHERE id=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,employee.getFirstName());
            ps.setString(2,employee.getLastName());
            ps.setString(3,employee.getRole());
            ps.setLong(4,employee.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(Employee employee) throws SQLException {
        String sql = "DELETE FROM employee WHERE id=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1,employee.getId());
            ps.executeUpdate();
        }

    }

    @Override
    public List<Employee> getAll() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setRole(resultSet.getString("role"));
                employeeList.add(employee);
            }
        }
        return employeeList;
    }
}
