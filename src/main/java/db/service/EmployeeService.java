package db.service;

import entity.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    void editEmployee(Employee employee);
    void deleteEmployeeById(Long id);
    List<Employee> getAllEmployees();
}
