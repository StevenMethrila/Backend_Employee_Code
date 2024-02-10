// Write your code here
package com.example.employee.repository;

import com.example.employee.model.Employee;
import java.util.*;

public interface EmployeeRepository {

    public ArrayList<Employee> getAll();

    public Employee createNewEmployee(Employee employee);

    public Employee getById(int employeeId);

    public Employee updateById(int employeeId, Employee employee);

    public void deleteById(int employeeId);
}