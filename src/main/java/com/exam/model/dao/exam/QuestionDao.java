package com.exam.model.dao.exam;

import com.exam.model.entity.exam.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends CrudRepository<Question, Long> {
}
