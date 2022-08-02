package com.luizmarcelo.jasperexample.repository.employee;

import com.luizmarcelo.jasperexample.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
