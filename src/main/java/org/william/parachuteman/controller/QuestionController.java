package org.william.parachuteman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.william.parachuteman.domain.Question;
import org.william.parachuteman.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<Question> findAll() {
        return questionService.findAll();
    }

    @GetMapping("/{questionId}")
    public Question findById(@PathVariable Integer questionId) {
        return questionService.findById(questionId);
    }

    @PostMapping
    public Integer create(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    @PutMapping("/{questionId}")
    public Integer update(@PathVariable Integer questionId,
                          @RequestBody Question question) {
        return questionService.updateQuestion(questionId, question);
    }


    @DeleteMapping("/{questionId}")
    public String delete(@PathVariable Integer questionId) {
        return questionService.delete(questionId);
    }
}
