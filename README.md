# 전국 대학 로고 및 학과 소개

### 기술스택
<img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white" width:240px><img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"><img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"><img src="https://img.shields.io/badge/thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white"><img src="https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=css3&logoColor=white"><img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white"><img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">

---

### 프로젝트 개요
영진전문대학교 캡스톤에 활용할 대학 정보 조회 및 인증을 위해 사용.

---

### 프로젝트 소개
- [공공데이터포털](https://www.data.go.kr/data/15014632/fileData.do)  [커리어넷](https://www.career.go.kr/cnet/front/openapi/openApiSchoolCenter.do) OpenApi를 활용하여 대학 정보 및 학과 정보 조회
- [로고이미지 참고 자료](https://github.com/hiphapis/univ_logos) 
Johan Kim
hiphapis
- 대학교 선택시 해당 대학 로고 이미지 노출

#### 초기 세팅 
- 행정구역에 맞는 regionCode 저장
- 행정구역명 필요에 맞게 변경 ( 서울특별시 -> 서울 , 경기도 -> 경기 )
  

#### 마무리
- 초기 openApi 로 받은 값들을 활용하여 데이터 가공 준비
- 받은 데이터를 활용하여 전국 대학 및 해당 대학 학과를 Python을 통해 가공 후 sql 문으로 저장 
- 활용 파이썬 파일 : univAndDepart.py  ,  logoMapping.py

---

### 이미지

<img src="https://github.com/dltldud2kr/University-Search-System/assets/105353307/f7c3c52e-8066-43d3-b7a3-0619610d5798" alt="면메인화>

