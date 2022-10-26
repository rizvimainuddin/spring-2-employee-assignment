package com.Mainuddin.RestfulWebServiceAssignment.Controller;

import com.Mainuddin.RestfulWebServiceAssignment.Employee;
import com.Mainuddin.RestfulWebServiceAssignment.Service.EmployeeDaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    EmployeeDaoService employeeDaoService;

    public EmployeeController(EmployeeDaoService employeeDaoService) {
        this.employeeDaoService = employeeDaoService;
    }

    @GetMapping(path = "/welcome")
    public String welcomeMessage(){
        return "Welcome to Spring Boot";
    }

    @GetMapping(path = "/employees")
    public List<Employee> getAllEmployees(){
        return employeeDaoService.getAllEmployee();
    }

    @GetMapping(path = "/employees/{id}")
    public Employee getEmployee(@PathVariable long id){
        Employee emp =  employeeDaoService.getEmployee(id);
        if(emp == null){
            throw new EmployeeNotFoundException("id:" + id);
        }
        return emp;
    }

    @PostMapping(path = "/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){

        Employee employee1 = employeeDaoService.saveEmployee(employee);

        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(employee1.getId())
                        .toUri();

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping(path ="/employees/{id}")
    public void deleteEmployee(@PathVariable long id){
        employeeDaoService.removeEmployee(id);
    }

    @PutMapping(path = "/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employee){

        Employee employee1 =  employeeDaoService.getEmployee(id);

        System.out.println(employee1.toString());

        employee1.setId((employee.getId()));
        employee1.setName(employee.getName());
        employee1.setAge(employee.getAge());

        employeeDaoService.saveEmployee(employee1);

            URI location =  ServletUriComponentsBuilder
                    .fromCurrentRequest().path("")
                    .buildAndExpand(employee1.getId())
                    .toUri();

        return ResponseEntity.created(location).build();

    }
}


