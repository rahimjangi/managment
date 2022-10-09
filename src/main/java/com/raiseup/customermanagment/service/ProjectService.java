package com.raiseup.customermanagment.service;

import com.raiseup.customermanagment.dto.ProjectStage;
import com.raiseup.customermanagment.model.Project;
import com.raiseup.customermanagment.repository.EmployeeRepository;
import com.raiseup.customermanagment.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ProjectStage> getProjectStage() {
        return projectRepository.getProjectStage();
    }
}
