package com.raiseup.customermanagment.controller;

import com.raiseup.customermanagment.model.Employee;
import com.raiseup.customermanagment.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @RequestMapping(value ={"","/"}, method = RequestMethod.GET)
    public String employeeList(Model model){
        model.addAttribute("employees",employeeService.findAll());
        return "employees/employee-list";
    }

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String newEmployee(Model model, Employee employee){
        model.addAttribute("employee",new Employee());
        return "employees/new-employee";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String createEmployee(Employee employee){
        employeeService.save(employee);
        return "redirect:/employees/new";
    }
}
