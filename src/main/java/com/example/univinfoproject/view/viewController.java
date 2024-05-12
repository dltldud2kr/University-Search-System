package com.example.univinfoproject.view;


import com.example.univinfoproject.Department.Department;
import com.example.univinfoproject.University.University;
import com.example.univinfoproject.University.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class viewController {
    private final UniversityService universityService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/univ/list")
    public String univList(Model model ) {

        List<University> list = universityService.universityList();

        model.addAttribute("list", list);
        return "hello";
    }
    @GetMapping("/dept/list")
    public String dptList(Model model ) {

        List<Department> list =  universityService.departmentList();

        model.addAttribute("list", list);
        return "hello";
    }

    @GetMapping("/search/univ")
    public String searchUniversities(Model model, @RequestParam(defaultValue = "") String search) {
        model.addAttribute("universities", universityService.searchUniversities(search));
        return "home";
    }

    @GetMapping("/search/dept")
    public String searchDepartments(Model model, @RequestParam(defaultValue = "") String search) {
        model.addAttribute("departments", universityService.searchDepartments(search));
        return "home";
    }

    @ResponseBody
    @GetMapping("/search/autocomplete")
    public List<University> autocompleteSuggestions(@RequestParam("term") String term) {
        return universityService.searchUniversities(term);  // 사용자의 입력에 따라 검색 결과 반환
    }

    @GetMapping("/get-departments")
    @ResponseBody
    public List<Department> getDepartments(@RequestParam Long univId) {
        return universityService.findByUniversityId(univId);
    }
}
