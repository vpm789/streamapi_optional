package pro.sky.java.course2.service;

import pro.sky.java.course2.Employees;

import java.awt.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employees getEmployeeMinSalaryDepart(int department);

    Employees getEmployeeMaxSalaryDepart(int department);

    Collection<Employees> getEmployeesDepart(int department);

    Map<Integer, List<Employees>> getEmployees();
}
