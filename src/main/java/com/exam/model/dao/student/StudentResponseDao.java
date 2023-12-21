package com.exam.model.dao.student;

import com.exam.model.entity.student.StudentResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentResponseDao extends CrudRepository<StudentResponse, Long> {
    @Query("SELECT SUM(s.scoreResponse) FROM StudentResponse s WHERE s.studentExam.studentExamId = ?1")
    Double calification(Long studentExamId);
}
