package pro.sky.homework28.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework28.entity.Employee;
import pro.sky.homework28.service.EmployeeDepartmentServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class EmployeeDepartmentController {
    private final EmployeeDepartmentServiceImpl departmentService;
    public EmployeeDepartmentController(EmployeeDepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/max-salary")
    public Employee maxSalaryDepartment(@RequestParam int departmentId){
        return departmentService.maxSalaryDepartment(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee minSalaryDepartment(@RequestParam int departmentId){
        return departmentService.minSalaryDepartment(departmentId);
    }
    @GetMapping(value = "/all",params = "departmentId")
    public List<Employee> getAllInDepartment(@RequestParam int departmentId){
        return departmentService.getAllInDepartment(departmentId);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllDepartment(){
        return departmentService.getAllDepartment();
    }
    @GetMapping("/index")
    public List<Employee> departmentIndexSalary(@RequestParam int indexSalary, @RequestParam int departmentId){
        return departmentService.departmentIndexSalary(indexSalary,departmentId);
    }
    @GetMapping("/sum")
    public String departmentIndexSalary(@RequestParam int departmentId){
        return "Сумма зарплат в " + departmentId + " отделе " + departmentService.sumDepartmentSalary(departmentId);
    }

    }


