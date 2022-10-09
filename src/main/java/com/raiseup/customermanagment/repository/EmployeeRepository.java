package com.raiseup.customermanagment.repository;

import com.raiseup.customermanagment.dto.EmployeeProject;
import com.raiseup.customermanagment.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(nativeQuery=true,value="select e.employee_id as employeeId,e.first_name as firstName,e.last_name as lastName,count(e.employee_id) as projectCount from employee e left join project_employee pe on e.employee_id=pe.employee_id group by e.employee_id")
    public List<EmployeeProject> employeeProjects();
}
