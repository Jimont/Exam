package com.exam.model.dao.student;

import com.exam.model.entity.student.StudentExam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentExamDao extends CrudRepository<StudentExam, Long> {
}
