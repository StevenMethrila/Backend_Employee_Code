/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 */

// Write your code here
package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeJpaService;
import java.util.*;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeJpaService ejs;

    @GetMapping("/employees")
    public ArrayList<Employee> getMethod() {
        return ejs.getAll();
    }

    @PostMapping("/employees")
    public Employee postMethod(@RequestBody Employee employee) {
        return ejs.createNewEmployee(employee);
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getByIdMethod(@PathVariable("employeeId") int employeeId) {
        return ejs.getById(employeeId);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee putMethod(@PathVariable("employeeId") int employeeId, @RequestBody Employee employee) {
        return ejs.updateById(employeeId, employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteMethod(@PathVariable("employeeId") int employeeId){
        ejs.deleteById(employeeId);
    }
}
