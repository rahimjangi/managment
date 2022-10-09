package com.raiseup.customermanagment.controller;

import com.raiseup.customermanagment.service.EmployeeService;
import com.raiseup.customermanagment.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {
    private final ProjectService projectService;
    private final EmployeeService employeeService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String projectList(Model model){
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("employees",employeeService.findAll());
        model.addAttribute("employeeProjects",employeeService.allEmployeeProject());
        model.addAttribute("projectStage",projectService.getProjectStage());
        return "main/home";
    }

}
