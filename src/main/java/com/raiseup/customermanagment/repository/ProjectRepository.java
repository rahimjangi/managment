package com.raiseup.customermanagment.repository;

import com.raiseup.customermanagment.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
