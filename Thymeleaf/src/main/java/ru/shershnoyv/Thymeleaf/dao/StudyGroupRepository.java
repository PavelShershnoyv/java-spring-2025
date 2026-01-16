package ru.shershnoyv.Thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shershnoyv.Thymeleaf.entity.StudyGroup;

@Repository
public interface StudyGroupRepository extends JpaRepository<StudyGroup, Integer> {
}
