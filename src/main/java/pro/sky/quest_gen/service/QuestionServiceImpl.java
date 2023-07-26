package pro.sky.quest_gen.service;

import pro.sky.quest_gen.entity.Question;
import pro.sky.quest_gen.exceptions.NoEnoughArgumentsException;
import pro.sky.quest_gen.exceptions.NoSuchQuestionException;
import pro.sky.quest_gen.service.api.QuestionService;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class QuestionServiceImpl implements QuestionService {



    final private List<Question> questions;


    public QuestionServiceImpl(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
        if (question == null || answer == null) {
            throw new NoEnoughArgumentsException();
        }
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new NoEnoughArgumentsException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
        } else {
            throw new NoSuchQuestionException();
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, questions.size());
        return questions.get(randomIndex);
    }
}
