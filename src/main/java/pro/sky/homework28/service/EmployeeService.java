package pro.sky.homework28.service;

import pro.sky.homework28.entity.Employee;

import java.util.Collection;

public interface EmployeeService {


    Employee add(String firstName, String lastName, int department, int salary);

    Employee delete(String firstName, String lastName, int department, int salary);

    Employee search(String firstName, String lastName, int department, int salary);

    Collection<Employee> findAll();
}
