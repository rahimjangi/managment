package com.raiseup.customermanagment.service;

import com.raiseup.customermanagment.model.Employee;
import com.raiseup.customermanagment.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee>findAll(){
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(new Employee());
    }
}
