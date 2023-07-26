package pro.sky.quest_gen.repository;

import org.springframework.stereotype.Repository;
import pro.sky.quest_gen.entity.Question;
import pro.sky.quest_gen.exceptions.NoSuchQuestionException;
import java.util.Collection;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {

    final private List<Question> questions;

    public QuestionRepositoryImpl(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public void add(Question question) {
        questions.add(question);
    }

    @Override
    public void remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
        } else {
            throw new NoSuchQuestionException();
        }
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
