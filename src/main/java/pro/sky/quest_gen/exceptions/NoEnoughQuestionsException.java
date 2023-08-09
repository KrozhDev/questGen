package pro.sky.quest_gen.exceptions;

public class NoEnoughQuestionsException extends RuntimeException {
    public NoEnoughQuestionsException(int amount) {
        super();
        System.out.println("В базе нет такого количества вопросов:" + amount);

    }
}
