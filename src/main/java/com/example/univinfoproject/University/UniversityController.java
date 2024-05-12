package com.example.univinfoproject.University;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/university")
public class UniversityController {
    private final DataSource dataSource;
    private final UniversityService universityService;
    private final UniversityRepository universityRepository;


    @PostMapping("/execute")
    public String executeSqlScript() throws IOException {
        // SQL 스크립트 파일 로드
        Resource universityScript = new ClassPathResource("university.sql");

        // 데이터베이스에 SQL 스크립트 실행
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(universityScript);
        populator.execute(dataSource);

        Resource departmentScript = new ClassPathResource("department.sql");

        // 데이터베이스에 SQL 스크립트 실행
        ResourceDatabasePopulator populator2 = new ResourceDatabasePopulator(departmentScript);
        populator2.execute(dataSource);
        return "SQL 스크립트가 성공적으로 실행되었습니다.";
    }


    @PostMapping("/logoUpt")
    public String updateLogoImageUrl() {
        // 이전 이미지 URL의 프리픽스와 새로운 이미지 URL의 프리픽스
        String oldImagePrefix = "PNG_";
        String newImageUrlPrefix = "https://jhuniversus.s3.ap-northeast-2.amazonaws.com/logo/PNG_"; // 변경된 부분

        // University 엔티티 리스트 가져오기
        List<University> universities = universityRepository.findAll();

        // 각 University 엔티티의 로고 이미지 URL 업데이트
        for (University university : universities) {
            String logoImg = university.getLogoImg();
            if (logoImg != null && logoImg.startsWith(oldImagePrefix)) {
                university.setLogoImg(newImageUrlPrefix + logoImg.substring(oldImagePrefix.length()));
            }
        }
        // 변경된 내용 저장
        universityRepository.saveAll(universities);

        return "Successfully updated logo image URLs.";
    }

}
