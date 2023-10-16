package general_work.core;

import general_work.exceptions.NullInput;
import general_work.exceptions.WrongSimbolInput;

/**
 * класс собирающий параметры для класса Toy
 * методы включают проброс Exception и проверку на корректность ввода
 */
public class ParametersSetting {
    private View view = new View();

    /**
     * Метод проверяет является ли введенная строка строкой из допустимых символов
     * 
     * @param string Принимает на вход строку
     * @return возвращает булево значение
     */
    public static boolean isText(String string) {
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        for (char item : string.toLowerCase().toCharArray()) {
            if (!alphabet.contains(String.valueOf(item))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Метод проверяет является ли введенная строка числом
     * 
     * @param string Принимает на вход строку
     * @return возвращает булево значение
     */
    public boolean isNumber(String string) {
        String str = "0123456789";
        for (char item : string.toCharArray()) {
            if (!str.contains(String.valueOf(item))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Метод создания строки для наименования игрушки
     * в теле метода вводится строка через сканер вызываемый классом view
     * выполняется проверка на NULL и на корректность ввода
     * 
     * @param string Принимает подсказку для ввода
     * @return возвращает введенную строку
     */
    public String createName(String string) {
        String text = view.getString(string);
        if (text == null || text.length() == 0 || " ".equals(text)) {
            throw new NullInput();
        } else if (!isText(text)) {
            throw new WrongSimbolInput();
        } else {
            return text.toLowerCase(); // наименование в нижнем регистре
        }
    }

    /**
     * Метод создания частоты выпадения
     * в теле метода вводится строка через сканер вызываемый классом view
     * выполняется проверка на null и на корректность ввода
     * 
     * @param string Принимает подсказку для ввода
     * @return возвращает введенную строку
     */
    public String createFrequency(String string) {
        String text = view.getString(string);
        if (text == null || text.length() == 0 || " ".equals(text)) {
            throw new NullInput();
        } else if (!isNumber(text)) {
            throw new WrongSimbolInput();
        } else {
            return text;
        }
    }

}