package pro.sky.java.course2.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.Employees;

import java.util.Collection;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeesService employeesService;

    public DepartmentServiceImpl(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }
    @Override
    public Employees getEmployeeMinSalaryDepart(int department) {
        Collection<Employees> employees = employeesService.printEmployee();
        Employees employeeMinSalaryDepartment = null;
        double minSalary = 0;
        for (Employees employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (minSalary == 0 || employee.getSalary() < minSalary) {
                    employeeMinSalaryDepartment = employee;
                    minSalary = employee.getSalary();
                }
            }
        }
        /*if (!employeeName.equals("")) {
            System.out.println("Сотрудник с минимальной зарплатой в отделе " + department + ": " + employeeName);
        } else {
            System.out.println("Отдел " + department + " не найден");
        }*/
        return employeeMinSalaryDepartment;
    }
    @Override
    public Employees getEmployeeMaxSalaryDepart(int department) {
        Collection<Employees> employees = employeesService.printEmployee();
        String employeeName = "";
        double maxSalary = 0;
        for (Employees employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (maxSalary == 0 || employee.getSalary() > maxSalary) {
                    employeeName = employee.getFirstName() + " " + employee.getLastName();
                    maxSalary = employee.getSalary();
                }
            }
        }
        if (!employeeName.equals("")) {
            System.out.println("Сотрудник с максимальной зарплатой в отделе " + department + ": " + employeeName);
        }
        return null;
    }
    @Override
    public Collection<Employees> getEmployeesDepart(int department) {
        Collection<Employees> employees = employeesService.printEmployee();
        for (Employees employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("Сотрудники отдела " + department + ": "
                        + employee.getFirstName() + " " + employee.getLastName() + " " + employee.getSalary());
            }
        }
        return null;
    }

}
