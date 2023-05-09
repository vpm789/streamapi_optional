package pro.sky.java.course2.collections.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.collections.Employees;
import pro.sky.java.course2.collections.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.collections.exception.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    Map<String, Employees> employees = new HashMap<>();

    @Override
    public void addEmployee(String firstName, String lastName, int department, double salary) {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        Employees employee = new Employees(firstName, lastName, department, salary);
        if (employees.containsKey(firstName + lastName)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(firstName + lastName, employee);
    }

    @Override
    public void deleteEmployee(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        if (!employees.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        employees.remove(firstName + lastName);
    }

    @Override
    public Employees findEmployee(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        if (!employees.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        return employees.get(firstName + lastName);
    }

    @Override
    public Collection<Employees> printEmployee() {
        return employees.values();
    }

}
