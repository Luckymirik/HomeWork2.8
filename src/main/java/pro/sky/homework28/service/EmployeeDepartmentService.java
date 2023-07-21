package pro.sky.homework28.service;

import pro.sky.homework28.entity.Employee;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public interface EmployeeDepartmentService {
    Employee maxSalaryDepartment(int department);

    Employee minSalaryDepartment(int department);

    List<Employee> getAllInDepartment(int department);

    Map<Integer, List<Employee>> getAllDepartment();

    List<Employee> departmentIndexSalary(int indexSalary, int department);
}
