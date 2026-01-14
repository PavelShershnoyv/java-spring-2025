package ru.shershnoyv.MySpringBoot2Dbase.service;

import org.springframework.stereotype.Service;
import ru.shershnoyv.MySpringBoot2Dbase.entity.Education;

import java.util.List;

@Service
public interface EducationService {
    List<Education> getAllEducation();

    Education saveEducation(Education education);

    Education getEducation(int id);

    void deleteEducation(int id);
}
