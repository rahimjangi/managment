package com.raiseup.customermanagment.service;

import com.raiseup.customermanagment.dto.ChartData;
import com.raiseup.customermanagment.model.Project;
import com.raiseup.customermanagment.repository.EmployeeRepository;
import com.raiseup.customermanagment.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;


    public void save(Project project,List<Long>ids) {
        for(int i=0;i<ids.size();i++){
//            employeeRepository.findById(ids.get(i)).get().setProject(project);
        }
        projectRepository.save(project);

    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Long id) {
        return projectRepository.findById(id).orElse(new Project());
    }

    public List<ChartData> getProjectStage() {
        return projectRepository.getProjectStatus();
    }
}
