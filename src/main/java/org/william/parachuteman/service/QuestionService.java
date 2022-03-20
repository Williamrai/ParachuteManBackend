package org.william.parachuteman.service;

import org.william.parachuteman.domain.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAll();

    Question findById(Integer questionId);

    Integer createQuestion(Question question);

    Integer updateQuestion(Integer questionId, Question question);

    String delete(Integer questionId);
}
