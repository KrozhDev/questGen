package pro.sky.quest_gen.service;

import pro.sky.quest_gen.entity.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
