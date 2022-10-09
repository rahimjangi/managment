package com.raiseup.customermanagment.repository;

import com.raiseup.customermanagment.dto.ProjectStage;
import com.raiseup.customermanagment.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Query(nativeQuery = true,value = "select project.stage as label, count(project.stage) as labelCount from project group by project.stage")
    public List<ProjectStage> getProjectStage();
}
