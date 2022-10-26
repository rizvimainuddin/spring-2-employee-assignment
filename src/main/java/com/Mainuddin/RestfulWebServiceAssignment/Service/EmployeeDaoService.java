package com.Mainuddin.RestfulWebServiceAssignment.Service;

import com.Mainuddin.RestfulWebServiceAssignment.Employee;
import org.springframework.stereotype.Component;

import java.util.List;


public interface EmployeeDaoService {

    public List<Employee> getAllEmployee();

    public Employee getEmployee(long id);

    public Employee saveEmployee(Employee employee);

    public void removeEmployee(long id);

}
