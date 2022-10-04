package com.raiseup.customermanagment.service;

import com.raiseup.customermanagment.model.Project;
import com.raiseup.customermanagment.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public void save(Project project) {
        projectRepository.save(project);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }
}
