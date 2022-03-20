package org.william.parachuteman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.william.parachuteman.domain.Category;
import org.william.parachuteman.domain.Question;
import org.william.parachuteman.repository.CategoryRepository;
import org.william.parachuteman.repository.QuestionRepository;
import org.william.parachuteman.service.impl.QuestionServiceImpl;

public class QuestionServiceImplTest {

    @InjectMocks
    private QuestionServiceImpl questionService;

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenQuestion_whenValidData_shouldCreateQuestion() {

        Mockito.when(categoryRepository.save(givenCategory())).thenReturn(givenCategory());
        Mockito.when(questionRepository.save(givenQuestion())).thenReturn(givenQuestion());
        var id = questionService.createQuestion(givenQuestion());

        Assertions.assertNotNull(id);
        Assertions.assertEquals(id, 4);


    }

    /*@Test
    public void givenQuestion_whenCategoryIsNull_throwExceptoin() {

        Mockito.when(categoryRepository.save()).thenReturn(givenCategory());
        Mockito.when(questionRepository.save(givenQuestion())).thenReturn(givenQuestion());
        var id = questionService.createQuestion(givenQuestion());

        Assertions.assertNotNull(id);
        Assertions.assertEquals(id, 4);


    }*/

    private Question givenQuestion() {
        Question question = new Question();
        question.setTitle("test title");
        question.setId(4);
        question.setCategory(givenCategory());

        return question;
    }

    private Category givenCategory() {
        var givenCategory = new Category();
        givenCategory.setCategoryId(1);
        givenCategory.setType("English");
        return givenCategory;
    }
}
