package pro.sky.java.course2.collections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.collections.Employees;
import pro.sky.java.course2.collections.service.EmployeesService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
    private final EmployeesService employeesService;

    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        employeesService.addEmployee(firstName, lastName);
        return firstName + " " + lastName + " added";
    }

    @GetMapping(path = "/remove")
    public String deleteEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        employeesService.deleteEmployee(firstName, lastName);
        return firstName + " " + lastName + " deleted";
    }
    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeesService.findEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<String> printEmployee() {
        return employeesService.printEmployee();
    }
}
