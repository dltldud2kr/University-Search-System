package com.example.univinfoproject.University;

import com.example.univinfoproject.Department.Department;
import com.example.univinfoproject.Department.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UniversityServiceImpl implements  UniversityService{

    private final UniversityRepository universityRepository;
    private final DepartmentRepository departmentRepository;


    @Override
    public List<University> universityList() {


        return universityRepository.findAll();
    }

    @Override
    public List<Department> departmentList() {

        return departmentRepository.findAll();
    }

    @Override
    public List<Department> matchDeptList(Long univId) {

        return departmentRepository.findByUnivId(univId);
    }

    @Override
    public List<University> searchUniversities(String keyword) {
        return universityRepository.findBySchoolNameContaining(keyword);
    }

    @Override
    public List<Department> searchDepartments(String keyword) {
        return departmentRepository.findByDeptNameContaining(keyword);
    }

    @Override
    public List<Department> findByUniversityId(Long universityId) {
        return departmentRepository.findByUnivId(universityId);
    }


    /**
     * @Decription  '대학교' -> '대' 로 학교 이름을 줄여주는 메서드
     * ex) 가천대학교 ->  가천대
     * @param universities
     * @author 이시영
     * @return
     */
    public List<University> findAllWithoutWord(List<University> universities) {

        for (University university : universities) {
            String schoolName = university.getSchoolName();
            // "대학교"라는 단어를 제거
            schoolName = schoolName.replace("학교", "");
            // 공백을 제거하고 리스트에 다시 설정
            university.setSchoolName(schoolName.trim());
        }
        return universities;
    }

}
