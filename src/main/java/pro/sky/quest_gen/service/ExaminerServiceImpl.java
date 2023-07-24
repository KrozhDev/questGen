package pro.sky.quest_gen.service;
import org.springframework.stereotype.Service;
import pro.sky.quest_gen.entity.Question;
import pro.sky.quest_gen.exceptions.NoEnoughQuestionsException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    Random random;
    private final QuestionService questionService;


    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new NoEnoughQuestionsException(amount);
        }
        Set<Question> randomQuestions = new HashSet<>();
        while (randomQuestions.size() < amount) {
            randomQuestions.add(questionService.getRandomQuestion());
        }
        return randomQuestions;
    }
}
