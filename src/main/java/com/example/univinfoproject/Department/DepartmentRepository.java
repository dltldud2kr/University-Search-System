package com.example.univinfoproject.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByUnivId(Long univId);

    List<Department> findByDeptNameContaining(String deptName);
}
