package pro.sky.homework28.service;

import org.springframework.stereotype.Service;
import pro.sky.homework28.entity.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeDepartmentServiceImpl implements EmployeeDepartmentService {
    private final EmployeeServiceImpl employeeService;

    public EmployeeDepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public Employee maxSalaryDepartment(int department){
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment()==department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);

    }
    @Override
    public Employee minSalaryDepartment(int department){
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment()==department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);

    }
    @Override
    public List<Employee> getAllInDepartment(int department){
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment()==department)
                .collect(Collectors.toList());


    }
    @Override
    public Map<Integer ,List<Employee>> getAllDepartment(){
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
    @Override
    public List<Employee> departmentIndexSalary(int indexSalary, int department) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .peek((employee) -> employee.setSalary((employee.getSalary() + employee.getSalary() * indexSalary / 100)))
                .collect(Collectors.toList());
    }

}
