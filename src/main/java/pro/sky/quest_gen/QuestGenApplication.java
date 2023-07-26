package pro.sky.quest_gen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pro.sky.quest_gen.service.api.QuestionService;
import pro.sky.quest_gen.service.QuestionServiceImpl;

import java.util.ArrayList;

@SpringBootApplication
public class QuestGenApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestGenApplication.class, args);
    }

    @Bean("mathQuestionService")
    public QuestionService mathQuestionService(){
        return new QuestionServiceImpl(new ArrayList<>());
    }

    @Bean("javaQuestionService")
    public QuestionService javaQuestionService(){
        return new QuestionServiceImpl(new ArrayList<>());
    }


}
