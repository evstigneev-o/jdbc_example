package db.dao;

import entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    void add(Employee employee) throws SQLException;

    Employee getById(Long id) throws SQLException;

    void update(Employee employee) throws SQLException;

    void delete(Employee employee) throws SQLException;

    List<Employee> getAll() throws SQLException;
}
