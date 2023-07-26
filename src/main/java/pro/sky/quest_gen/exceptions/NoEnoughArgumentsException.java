package pro.sky.quest_gen.exceptions;

public class NoEnoughArgumentsException extends RuntimeException {
    public NoEnoughArgumentsException(){
        super();
        System.out.println("Не достаточно данных");
    }
}
