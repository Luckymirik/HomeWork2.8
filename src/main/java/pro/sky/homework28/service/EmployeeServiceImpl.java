package pro.sky.homework28.service;

import org.springframework.stereotype.Service;
import pro.sky.homework28.entity.Employee;
import pro.sky.homework28.exception.EmployeeAlreadyAddedException;
import pro.sky.homework28.exception.EmployeeNotFoundException;
import pro.sky.homework28.exception.EmployeeStorageIsFullException;

import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int SIZE=10;

    private final List<Employee> employees = new ArrayList<>(SIZE);
    @Override
    public Employee add(String firstName, String lastName, int department, int salary){
        Employee employee = new Employee(firstName,lastName,department,salary);
        if(employees.size()>SIZE){
            throw new EmployeeStorageIsFullException();
        }
        for (Employee e: employees) {
            if(e.equals(employee)){
                throw new EmployeeAlreadyAddedException();
            }

        }
        employees.add(employee);
        return employee;
    }
    @Override
    public Employee delete(String firstName, String lastName, int department, int salary){
        Employee employee = new Employee(firstName,lastName,department,salary);
        if(employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
    @Override
    public Employee search(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName,department,salary);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }


    public List<Employee> findAll() {
        return new  ArrayList<>(employees);
    }
}
