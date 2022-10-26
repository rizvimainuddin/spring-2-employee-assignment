package com.Mainuddin.RestfulWebServiceAssignment.Service;

import com.Mainuddin.RestfulWebServiceAssignment.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDaoServiceImpl implements EmployeeDaoService{

    private static List<Employee> allEmployees =  new ArrayList<>();

    static {
        allEmployees.add(new Employee(1,"ABC" ,23));
        allEmployees.add(new Employee(2,"DEF" ,24));
        allEmployees.add(new Employee(3,"XYZ" ,25));
    }

    @Override
    public List<Employee> getAllEmployee() {
        return allEmployees;
    }

    @Override
    public Employee getEmployee(long id) {
        return allEmployees.stream()
                .filter(employee -> employee.getId()==(id))
                .findFirst().orElse(null);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        allEmployees.add(employee);
        return employee;
    }

    @Override
    public void removeEmployee(long id) {
        allEmployees.removeIf(employee -> employee.getId() == id);
    }

}
