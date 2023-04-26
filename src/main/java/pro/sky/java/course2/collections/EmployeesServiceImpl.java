package pro.sky.java.course2.collections;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    List<Employees> employees = new ArrayList<>(List.of(
            new Employees("Иван", "Красавин"),
            new Employees("Серега", "Тафгай"),
            new Employees("Илья", "Муромец"),
            new Employees("Сашка", "Череп")
    ));

    @Override
    public void addEmployee(Employees employee) {
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else if (Objects.equals(employee.getFirstName(), "") || Objects.equals(employee.getLastName(), "")) {
            throw new RuntimeException("Enter FirstName and LastName employee's");
        } else {
            employees.add(employee);
        }
    }

    @Override
    public void deleteEmployee(Employees employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
        } else {
            throw new EmployeeNotFoundException("Employee did not find");
        }

    }

    @Override
    public String findEmployee(Employees employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Employee did not find");
        }
        final String employeeDescription = ""
                + employee.getFirstName() + " "
                + employee.getLastName();
            return employeeDescription;
    }
    @Override
    public List<Employees> printEmployee() {
        return employees;
    }

}
