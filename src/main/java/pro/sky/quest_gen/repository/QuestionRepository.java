package pro.sky.quest_gen.repository;

import pro.sky.quest_gen.entity.Question;

import java.util.Collection;

public interface QuestionRepository {

    void add(Question question);

    void remove(Question question);

    boolean contains(Question question);

    Collection<Question> getAll();

}
