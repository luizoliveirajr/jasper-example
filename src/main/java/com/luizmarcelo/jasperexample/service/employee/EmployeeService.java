package com.luizmarcelo.jasperexample.service.employee;

import com.luizmarcelo.jasperexample.model.employee.Employee;
import com.luizmarcelo.jasperexample.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        return this.employeeRepository.findAll();
    }
}
