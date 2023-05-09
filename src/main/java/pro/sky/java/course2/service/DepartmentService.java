package pro.sky.java.course2.service;

import pro.sky.java.course2.Employees;

import java.util.Collection;

public interface DepartmentService {
    Employees getEmployeeMinSalaryDepart(int department);

    Employees getEmployeeMaxSalaryDepart(int department);

    Collection<Employees> getEmployeesDepart(int department);
}
