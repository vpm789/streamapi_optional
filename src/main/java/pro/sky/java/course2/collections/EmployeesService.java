package pro.sky.java.course2.collections;

import java.util.List;

public interface EmployeesService {

    void addEmployee(Employees employee);

    void deleteEmployee(Employees employee);

    String findEmployee(Employees employee);

    List<Employees> printEmployee();
}
