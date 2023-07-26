//package pro.sky.quest_gen.service;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import pro.sky.quest_gen.entity.Question;
//import pro.sky.quest_gen.exceptions.NoSuchQuestionException;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class JavaQuestionServiceTest {
//
//
//
//    private JavaQuestionService javaQuestionService;
//
//    private Question question;
//    private Question question2;
//
//
//    @BeforeEach
//    void setUp() {
//        javaQuestionService = new JavaQuestionService();
//        question = new Question("Вопрос", "Ответ");
//        question2 = new Question("Почему?", "Потому");
//    }
//
//
//    @Test
//    void removeAndAdd() {
//        javaQuestionService.add(question);
//        javaQuestionService.add("Почему?","Потому");
//        javaQuestionService.remove(question);
//        javaQuestionService.remove(question2);
//        Assertions.assertThrows(NoSuchQuestionException.class, () -> javaQuestionService.remove(question));
//        Assertions.assertThrows(NoSuchQuestionException.class, () -> javaQuestionService.remove(question2));
//
//    }
//
//    @Test
//    void getAll() {
//        List<Question> expected = new ArrayList<>();
//        expected.add(question);
//        expected.add(question2);
//
//        javaQuestionService.add(question);
//        javaQuestionService.add(question2);
//
//        Assertions.assertEquals(expected,javaQuestionService.getAll());
//    }
//
//    @Test
//    void getRandomQuestion() {
//        javaQuestionService.add(question);
//
//        Question expected = question;
//
//        Assertions.assertEquals(expected, javaQuestionService.getRandomQuestion());
//    }
//}