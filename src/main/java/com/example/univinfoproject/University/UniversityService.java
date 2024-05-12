package com.example.univinfoproject.University;

import com.example.univinfoproject.Department.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UniversityService {

    List<University> universityList();

    List<Department> departmentList();

    List<Department> matchDeptList(Long univId);

    List<University> searchUniversities(String keyword);
    List<Department> searchDepartments(String keyword);
    List<Department> findByUniversityId(Long universityId);
}
