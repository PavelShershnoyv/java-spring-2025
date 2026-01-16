package ru.shershnoyv.Thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shershnoyv.Thymeleaf.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
