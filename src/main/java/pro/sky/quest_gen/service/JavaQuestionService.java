//package pro.sky.quest_gen.service;
//
//import org.springframework.stereotype.Service;
//import pro.sky.quest_gen.entity.Question;
//import pro.sky.quest_gen.exceptions.NoEnoughArgumentsException;
//import pro.sky.quest_gen.exceptions.NoSuchQuestionException;
//
//import java.util.*;
//import java.util.concurrent.ThreadLocalRandom;
//
//
//@Service
//public class JavaQuestionService implements QuestionService {
//
//    private List<Question> javaQuestions = new ArrayList<>();
//    @Override
//    public Question add(String question, String answer) {
//        if (question == null || answer == null) {
//            throw new NoEnoughArgumentsException();
//        }
//        Question newQuestion = new Question(question, answer);
//        javaQuestions.add(newQuestion);
//        return newQuestion;
//    }
//
//    @Override
//    public Question add(Question question) {
//        if (question == null) {
//            throw new NoEnoughArgumentsException();
//        }
//        javaQuestions.add(question);
//        return question;
//    }
//
//    @Override
//    public Question remove(Question question) {
//        if (javaQuestions.contains(question)) {
//            javaQuestions.remove(question);
//        } else {
//            throw new NoSuchQuestionException();
//        }
//
//        return question;
//    }
//
//    @Override
//    public Collection<Question> getAll() {
//        return javaQuestions;
//    }
//
//    @Override
//    public Question getRandomQuestion() {
//        int randomIndex = ThreadLocalRandom.current().nextInt(0, javaQuestions.size());
//        return javaQuestions.get(randomIndex);
//    }
//}
