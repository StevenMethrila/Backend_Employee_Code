/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 */

// Write your code here
package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.employee.repository.EmployeeJpaRepository;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.model.Employee;
import java.util.*;

@Service
public class EmployeeJpaService implements EmployeeRepository {
    @Autowired
    EmployeeJpaRepository ejr;

    public ArrayList<Employee> getAll() {
        List<Employee> l = ejr.findAll();
        ArrayList<Employee> arr = new ArrayList<>(l);
        return arr;
    }

    @Override
    public Employee createNewEmployee(Employee employee) {
        ejr.save(employee);
        return employee;
    }

    @Override
    public Employee getById(int employeeId) {
        try {
            Employee e = ejr.findById(employeeId).get();
            return e;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Employee updateById(int employeeId, Employee employee) {
        try {
            Employee e = ejr.findById(employeeId).get();
            if (employee.getEmployeeName() != null) {
                e.setEmployeeName(employee.getEmployeeName());
            }
            if (employee.getEmail() != null) {
                e.setEmail(employee.getEmail());
            }
            if (employee.getDepartment() != null) {
                e.setDepartment(employee.getDepartment());
            }
            ejr.save(e);
            return e;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteById(int employeeId){
        try{
            ejr.deleteById(employeeId);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
