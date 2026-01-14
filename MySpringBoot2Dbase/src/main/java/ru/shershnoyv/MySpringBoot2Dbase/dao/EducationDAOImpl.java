package ru.shershnoyv.MySpringBoot2Dbase.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.shershnoyv.MySpringBoot2Dbase.entity.Education;

import java.util.List;

@Slf4j
@Repository
public class EducationDAOImpl implements EducationDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Education> getAllEducation() {
        Query query = entityManager.createQuery("from Education");
        List<Education> allEducation = query.getResultList();
        log.info("getAllEducation" + allEducation);
        return allEducation;
    }

    @Override
    public Education saveEducation(Education education) {
        return entityManager.merge(education);
    }

    @Override
    public Education getEducation(int id) {
        return entityManager.find(Education.class, id);
    }

    @Override
    public void deleteEducation(int id) {
        Query query = entityManager.createQuery("delete from Education where id=:educationId");
        query.setParameter("educationId", id);
        query.executeUpdate();
    }
}
