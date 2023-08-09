package pro.sky.quest_gen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.quest_gen.entity.Question;
import pro.sky.quest_gen.exceptions.NoEnoughArgumentsException;
import pro.sky.quest_gen.exceptions.NoSuchQuestionException;
import pro.sky.quest_gen.repository.QuestionRepository;
import pro.sky.quest_gen.service.api.QuestionService;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service("java")
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;


    private JavaQuestionService(@Qualifier("javaQuestionService") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        if (question == null || answer == null) {
            throw new NoEnoughArgumentsException();
        }
        Question newQuestion = new Question(question, answer);
        questionRepository.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new NoEnoughArgumentsException();
        }
        questionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questionRepository.contains(question)) {
            questionRepository.remove(question);
        } else {
            throw new NoSuchQuestionException();
        }

        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questions = questionRepository.getAll().stream().toList();
        int randomIndex = ThreadLocalRandom.current().nextInt(0, questions.size());
        return questions.get(randomIndex);
    }
}
