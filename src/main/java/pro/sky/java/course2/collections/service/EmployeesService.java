package pro.sky.java.course2.collections.service;

import java.util.Collection;

public interface EmployeesService {

    void addEmployee(String firstName, String lastName);

    void deleteEmployee(String firstName, String lastName);

    String findEmployee(String firstName, String lastName);

    Collection<String> printEmployee();
}
