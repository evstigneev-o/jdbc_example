package db.service;

import db.dao.EmployeeDAO;
import db.dao.EmployeeDAOImpl;
import entity.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public void addEmployee(Employee employee) {
        if (employee != null) {
            try {
                employeeDAO.add(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = null;
        if (id > 0) {
            try {
                employee = employeeDAO.getById(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employee;
    }

    @Override
    public void editEmployee(Employee employee) {
        if (employee != null) {
            try {
                employeeDAO.update(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        if (employee != null && employee.getId() != null && employee.getId() > 0) {
            try {
                employeeDAO.delete(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = null;
        try {
            employeeList = employeeDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

}
