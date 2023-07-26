//package pro.sky.quest_gen.service;
//
//import org.springframework.stereotype.Service;
//import pro.sky.quest_gen.entity.Question;
//import pro.sky.quest_gen.exceptions.NoEnoughArgumentsException;
//import pro.sky.quest_gen.exceptions.NoSuchQuestionException;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.ThreadLocalRandom;
//
//@Service
//public class MathQuestionService implements QuestionService {
//
//
//    private List<Question> mathQuestions = new ArrayList<>();
//
//    @Override
//    public Question add(String question, String answer) {
//        if (question == null || answer == null) {
//            throw new NoEnoughArgumentsException();
//        }
//        Question newQuestion = new Question(question, answer);
//        mathQuestions.add(newQuestion);
//        return newQuestion;
//    }
//
//    @Override
//    public Question add(Question question) {
//        if (question == null) {
//            throw new NoEnoughArgumentsException();
//        }
//        mathQuestions.add(question);
//        return question;
//    }
//
//    @Override
//    public Question remove(Question question) {
//        if (mathQuestions.contains(question)) {
//            mathQuestions.remove(question);
//        } else {
//            throw new NoSuchQuestionException();
//        }
//
//        return question;
//    }
//
//    @Override
//    public Collection<Question> getAll() {
//        return mathQuestions;
//    }
//
//    @Override
//    public Question getRandomQuestion() {
//        int randomIndex = ThreadLocalRandom.current().nextInt(0, mathQuestions.size());
//        return mathQuestions.get(randomIndex);
//    }
//}
