package com.example.univinfoproject.University;


import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Slf4j
public class University {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UNIVERSITY_SEQ")
    @SequenceGenerator(name = "UNIVERSITY_SEQ", sequenceName = "university_sequence", allocationSize = 1)
    private Long id;

    private String schoolName;
    private String regionCode;
    private String region;

    @Column(name = "logo_img")
    private String logoImg;
}
