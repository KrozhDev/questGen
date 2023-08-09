//package pro.sky.quest_gen.service;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import pro.sky.quest_gen.entity.Question;
//import pro.sky.quest_gen.exceptions.NoEnoughQuestionsException;
//import pro.sky.quest_gen.service.api.QuestionService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//
//
//@ExtendWith(MockitoExtension.class)
//class ExaminerServiceImplTest {
//
//    @Mock
//    private QuestionService questionService;
//
//    @InjectMocks
//    ExaminerServiceImpl examinerService;
//
//    private Question question;
//    private Question question2;
//
//    @Test
//    void getQuestions() {
//        question = new Question("Вопрос", "Ответ");
//        question2 = new Question("Почему?", "Потому");
//        List<Question> questions = new ArrayList<>();
//        questions.add(question);
//        questions.add(question2);
//
//        when(questionService.getAll()).thenReturn(questions);
//        Assertions.assertThrows(NoEnoughQuestionsException.class,() -> examinerService.getQuestions(3));
//
//        when(questionService.getRandomQuestion()).thenReturn(question);
//        Assertions.assertEquals(1,examinerService.getQuestions(1).size());
//    }
//
//}