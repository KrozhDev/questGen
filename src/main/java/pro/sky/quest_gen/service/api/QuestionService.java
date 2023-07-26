package pro.sky.quest_gen.service.api;

import pro.sky.quest_gen.entity.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove (Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

}
