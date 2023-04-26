package pro.sky.java.course2.collections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
    private final EmployeesService employeesService;

    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        Employees employee = new Employees(
                firstName,
                lastName
        );
        employeesService.addEmployee(employee);
        return employee + " added";
    }

    @GetMapping(path = "/remove")
    public String deleteEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        Employees employee = new Employees(
                firstName,
                lastName
        );
        employeesService.deleteEmployee(employee);
        return employee + " deleted";
    }
    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        Employees employee = new Employees(
                firstName,
                lastName
        );
        return "Employee: " + employeesService.findEmployee(employee) + " found";
    }

    @GetMapping
    public List<Employees> printEmployee() {
        return employeesService.printEmployee();
    }
}
