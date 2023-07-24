package pro.sky.quest_gen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.quest_gen.entity.Question;
import pro.sky.quest_gen.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java/")
public class JavaController {

    private final JavaQuestionService javaQuestionService;

    public JavaController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("questionText") String questionText,
                        @RequestParam("questionAnswer") String questionAnswer) {

        return javaQuestionService.add(questionText,questionAnswer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("questionText") String questionText,
                        @RequestParam("questionAnswer") String questionAnswer) {

        Question questionToRemove = new Question(questionText, questionAnswer);

        return javaQuestionService.remove(questionToRemove);
    }

    @GetMapping()
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }
}
