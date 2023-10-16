package general_work.exceptions;

public class NullInput extends RuntimeException{
    public NullInput() {
        super("Некорректный ввод, строка не может быть пустой");
    }
}