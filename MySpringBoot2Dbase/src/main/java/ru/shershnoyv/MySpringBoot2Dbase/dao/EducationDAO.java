package ru.shershnoyv.MySpringBoot2Dbase.dao;

import org.springframework.stereotype.Repository;
import ru.shershnoyv.MySpringBoot2Dbase.entity.Education;
import ru.shershnoyv.MySpringBoot2Dbase.entity.Student;

import java.util.List;

@Repository
public interface EducationDAO {
    List<Education> getAllEducation();

    Education saveEducation(Education education);

    Education getEducation(int id);

    void deleteEducation(int id);
}
