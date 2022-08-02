package com.luizmarcelo.jasperexample.service;

import com.luizmarcelo.jasperexample.model.Employee;
import com.luizmarcelo.jasperexample.repository.EmployeeRepository;
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
