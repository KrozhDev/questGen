package pro.sky.quest_gen.service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.quest_gen.entity.Question;
import pro.sky.quest_gen.exceptions.NoEnoughQuestionsException;
import pro.sky.quest_gen.service.api.ExaminerService;
import pro.sky.quest_gen.service.api.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService mathQuestionService;
    private final QuestionService javaQuestionService;


    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }


    //todo пока поставил заглушку на метод ниже, нужно будет передаелать, чтобы мешал разные вопросы
    @Override
    public Collection<Question> getQuestions(int amount) {
        if (javaQuestionService.getAll().size() < amount) {
            throw new NoEnoughQuestionsException(amount);
        }
        Set<Question> randomQuestions = new HashSet<>();
        while (randomQuestions.size() < amount) {
            randomQuestions.add(javaQuestionService.getRandomQuestion());
        }
        return randomQuestions;
    }
}
