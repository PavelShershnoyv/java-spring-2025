package ru.shershnoyv.MySpringBoot2Dbase.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shershnoyv.MySpringBoot2Dbase.dao.EducationDAO;
import ru.shershnoyv.MySpringBoot2Dbase.entity.Education;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {

    @Autowired
    private EducationDAO educationDAO;

    @Override
    @Transactional
    public List<Education> getAllEducation() {
        return educationDAO.getAllEducation();
    }

    @Override
    @Transactional
    public Education saveEducation(Education education) {
        return educationDAO.saveEducation(education);
    }

    @Override
    @Transactional
    public Education getEducation(int id) {
        return educationDAO.getEducation(id);
    }

    @Override
    @Transactional
    public void deleteEducation(int id) {
        educationDAO.deleteEducation(id);
    }
}
