package com.raiseup.customermanagment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raiseup.customermanagment.dto.ChartData;
import com.raiseup.customermanagment.service.EmployeeService;
import com.raiseup.customermanagment.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    @Value("${spring.application.name}")
    private String applicationName;
    private final ProjectService projectService;
    private final EmployeeService employeeService;
    Map<String, Object> map= new HashMap<>();

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String projectList(Model model) throws JsonProcessingException {
        model.addAttribute("applicationName",applicationName);
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("employees",employeeService.findAll());
        model.addAttribute("employeeProjects",employeeService.allEmployeeProject());
        model.addAttribute("projectStage",projectService.getProjectStage());
        ObjectMapper objectMapper= new ObjectMapper();
        List<ChartData>projectData=projectService.getProjectStage();
        String jsonString = objectMapper.writeValueAsString(projectData);
        model.addAttribute("projectStatus",jsonString);
        return "main/home";
    }

}
