package db.service;

import db.dao.EmployeeDAO;
import db.dao.EmployeeDAOImpl;
import entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public void addEmployee(Employee employee) {
        if (employee != null) {
            try {
                employeeDAO.add(employee);
            } catch (SQLException e) {
                logger.error("Something went wrong",e);
            }
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = null;
        if (id != null && id > 0) {
            try {
                employee = employeeDAO.getById(id);
            } catch (SQLException e) {
                logger.error("Something went wrong",e);
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
                logger.error("Something went wrong",e);
            }
        }
    }

    @Override
    public void deleteEmployeeById(Long id) {
        if (id != null && id > 0) {
            try {
                employeeDAO.delete(id);
            } catch (SQLException e) {
                logger.error("Something went wrong",e);
            }
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = null;
        try {
            employeeList = employeeDAO.getAll();
        } catch (SQLException e) {
            logger.error("Something went wrong",e);
        }
        return employeeList;
    }

}
