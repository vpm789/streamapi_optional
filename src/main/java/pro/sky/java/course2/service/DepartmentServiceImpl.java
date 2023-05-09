package pro.sky.java.course2.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.Employees;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeesService employeesService;

    public DepartmentServiceImpl(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @Override
    public Employees getEmployeeMinSalaryDepart(int department) {
        Collection<Employees> employees = employeesService.printEmployee();
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employees::getSalary))
                .orElseThrow();
    }

    @Override
    public Employees getEmployeeMaxSalaryDepart(int department) {
        Collection<Employees> employees = employeesService.printEmployee();
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employees::getSalary))
                .orElseThrow();
    }

    @Override
    public Collection<Employees> getEmployeesDepart(int department) {
        Collection<Employees> employees = employeesService.printEmployee();
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employees>> getEmployees() {
        Collection<Employees> employees = employeesService.printEmployee();
        return employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartment));
    }

}
