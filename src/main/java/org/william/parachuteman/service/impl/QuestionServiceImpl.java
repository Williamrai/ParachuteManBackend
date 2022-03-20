package org.william.parachuteman.service.impl;

import lombok.extern.java.Log;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.william.parachuteman.domain.Question;
import org.william.parachuteman.repository.CategoryRepository;
import org.william.parachuteman.repository.QuestionRepository;
import org.william.parachuteman.service.QuestionService;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    //private static final Logger log = LogFactory.getFactory(QuestionServiceImpl.class);
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question findById(Integer questionId) {
        return questionRepository.getById(questionId);
    }

    @Override
    public Integer createQuestion(Question question) {
        try {
            var category = categoryRepository.save(question.getCategory());
            question.setCategoryId(category.getCategoryId());
        }catch (Exception ex){
            System.out.println(ex);
        }

        return questionRepository.save(question).getId();
    }

    @Override
    public Integer updateQuestion(Integer questionId, Question question) {
        var questionJpaEntity = findById(questionId);
        questionJpaEntity.setTitle(question.getTitle());
        return questionRepository.save(questionJpaEntity).getId();
    }

    @Override
    public String delete(Integer questionId) {
        questionRepository.delete(findById(questionId));
        return "deleted successfully";
    }
}
