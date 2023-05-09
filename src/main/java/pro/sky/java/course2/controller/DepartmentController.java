package pro.sky.java.course2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.Employees;
import pro.sky.java.course2.service.DepartmentService;

import java.util.Collection;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/min-salary")
    public Employees getEmployeeMinSalaryDepart(@RequestParam("department") int department) {
        return departmentService.getEmployeeMinSalaryDepart(department);
    }

    @GetMapping(path = "/max-salary")
    public Employees getEmployeeMaxSalaryDepart(@RequestParam("department") int department) {
        return departmentService.getEmployeeMaxSalaryDepart(department);
    }

    @GetMapping(path = "/all")
    public Collection<Employees> getEmployeesDepart(@RequestParam("department") int department) {
        return departmentService.getEmployeesDepart(department);
    }
}
