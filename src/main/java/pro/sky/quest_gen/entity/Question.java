package pro.sky.quest_gen.entity;

import java.util.Objects;

public class Question {

    private String question;
    private String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        Question question = (Question) o;
        return (this.answer.equals(question.answer)) && (this.question.equals((question.question)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.answer, this.question);
    }

    @Override
    public String toString(){
        return this.question + "\n" + this.answer;
    }
}
