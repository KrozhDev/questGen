package pro.sky.quest_gen.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.quest_gen.entity.Question;
import pro.sky.quest_gen.service.MathQuestionService;
import pro.sky.quest_gen.service.api.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math/")
public class MathController {

    private final MathQuestionService mathQuestionService;

    public MathController(@Qualifier("math") MathQuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("questionText") String questionText,
                        @RequestParam("questionAnswer") String questionAnswer) {

        return mathQuestionService.add(questionText,questionAnswer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("questionText") String questionText,
                        @RequestParam("questionAnswer") String questionAnswer) {

        Question questionToRemove = new Question(questionText, questionAnswer);

        return mathQuestionService.remove(questionToRemove);
    }

    @GetMapping()
    public Collection<Question> getAll() {
        return mathQuestionService.getAll();
    }
}
