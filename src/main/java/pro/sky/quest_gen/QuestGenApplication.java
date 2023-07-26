package pro.sky.quest_gen;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pro.sky.quest_gen.entity.Question;
import pro.sky.quest_gen.repository.QuestionRepository;
import pro.sky.quest_gen.repository.QuestionRepositoryImpl;
import pro.sky.quest_gen.service.api.QuestionService;
import pro.sky.quest_gen.service.QuestionServiceImpl;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class QuestGenApplication {

    final private List<Question> questions = new ArrayList<>();

    public static void main(String[] args) {SpringApplication.run(QuestGenApplication.class, args);}

    @Bean("mathQuestionService")
    public QuestionRepository mathQuestionService(){return new QuestionRepositoryImpl(questions);}

    @PostConstruct
    public void init1(){
        Question q1 = new Question("Для чего нужен Component Scan?",
                "Первый шаг для описания Spring Beans это добавление аннотации — @Component, или @Service, или @Repository.\n" +
                        "Однако, Spring ничего не знает об этих бинах, если он не знает где искать их. То, что скажет Spring где искать эти бины и называется Component Scan. В @ComponentScan вы указываете пакеты, которые должны сканироваться.\n" +
                        "Spring будет искать бины не только в пакетах для сканирования, но и в их подпакетах.");
        Question q2 = new Question("2 Как вы добавите Component Scan в Spring Boot?",
                "@SpringBootApplication определяет автоматическое сканирование пакета, где находится класс Application\n" +
                        "Всё будет в порядке, ваш код целиком находится в указанном пакете или его подпакетах.\n" +
                        "Однако, если необходимый вам компонент находится в другом пакете, вы должны использовать дополнительно аннотацию @ComponentScan, где перечислите все дополнительные пакеты для сканирования");
        questions.add(q1);
        questions.add(q2);
    }


    @Bean("javaQuestionService")
    public QuestionRepository javaQuestionService(){ return new QuestionRepositoryImpl(questions);}

    @PostConstruct
    public void init2(){
        Question q1 = new Question("2 + 3 = ", "5");
        Question q2 = new Question("5 - 2 = ", "3");

        questions.add(q1);
        questions.add(q2);

    }




}
