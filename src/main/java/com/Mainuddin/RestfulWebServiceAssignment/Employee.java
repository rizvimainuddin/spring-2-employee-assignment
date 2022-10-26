package com.Mainuddin.RestfulWebServiceAssignment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

public class Employee {
    @NotNull(message = "Can't be null")
    private long id;

    @Size(min = 2,message = "Minimum 2 characters needed")
    private String name;

    private int age;

    public Employee(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee [Id:"+this.id+" Name:" +this.name+ " Age:" + age +"]";
    }
}
