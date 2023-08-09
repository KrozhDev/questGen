package pro.sky.quest_gen.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.quest_gen.entity.Question;
import pro.sky.quest_gen.exceptions.NoEnoughQuestionsException;
import pro.sky.quest_gen.repository.QuestionRepository;
import pro.sky.quest_gen.service.api.ExaminerService;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionRepository mathQuestionRepository;
    private final QuestionRepository javaQuestionRepository;


    public ExaminerServiceImpl(@Qualifier("mathQuestionService") QuestionRepository mathQuestionRepository,
                               @Qualifier("javaQuestionService") QuestionRepository javaQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (javaQuestionRepository.getAll().size() + mathQuestionRepository.getAll().size() < amount) {
            throw new NoEnoughQuestionsException(amount);
        }
        Set<Question> randomQuestions = new HashSet<>();
        int counter = 0;
        while (randomQuestions.size() < amount) {
            if (counter++ % 2 == 0) {
                randomQuestions.add(getRandomQuestion(javaQuestionRepository));
            } else {
                randomQuestions.add(getRandomQuestion(mathQuestionRepository));
            }
        }
        return randomQuestions;
    }

    private Question getRandomQuestion(QuestionRepository questionRepository) {
        List<Question> questions = questionRepository.getAll().stream().toList();
        int randomIndex = ThreadLocalRandom.current().nextInt(0, questions.size());
        return questions.get(randomIndex);
    }


}
