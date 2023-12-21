package com.exam.model.dao.exam;

import com.exam.model.entity.exam.Exam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamDao extends CrudRepository<Exam, Long> {
}
