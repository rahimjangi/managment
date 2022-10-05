package com.raiseup.customermanagment.controller;

import com.raiseup.customermanagment.model.Project;
import com.raiseup.customermanagment.service.EmployeeService;
import com.raiseup.customermanagment.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;
    private final EmployeeService employeeService;



    @RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
    public String getProject(@PathVariable("projectId") Long id){
        return "projects/project";
    }

    @RequestMapping("/new")
    public String newProject(Project project, Model model){
        model.addAttribute("project",new Project());
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("allEmployees",employeeService.findAll());
        return "projects/new-project";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String createProject(Project project, @RequestParam List<Long> employees){

        projectService.save(project,employees);
        return "redirect:/projects/new";
    }

    @RequestMapping(value = "/{projectId}", method = RequestMethod.POST)
    public String updateProject(@PathVariable("projectId") Long id){
        return "projects/project";
    }

    @RequestMapping(value = "/{projectId}", method = RequestMethod.DELETE)
    public String deleteProject(@PathVariable("projectId") Long id){
        return "projects/project";
    }

}
