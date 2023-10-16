package general_work.exceptions;

public class WrongSimbolInput extends RuntimeException{
    public WrongSimbolInput() {
        super("Введены некорректные символы.");
    }
}