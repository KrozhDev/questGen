package pro.sky.quest_gen.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoSuchQuestionException extends RuntimeException {
    public NoSuchQuestionException() {
        super();
        System.out.println("Вопрос не найден");
    }
}
