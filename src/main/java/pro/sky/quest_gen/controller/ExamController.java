package pro.sky.quest_gen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.quest_gen.entity.Question;
import pro.sky.quest_gen.service.api.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java/") //todo адрес на какой изменить?
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService, ExaminerService examinerService1) {
        this.examinerService = examinerService1;
    }

    //todo получать рандомные вопросы по 5 штук от мат и джава

    @GetMapping("/test/")
    public Collection<Question> test(@RequestParam("amount") int amount) {
        return examinerService.getQuestions(amount);
    }


}
