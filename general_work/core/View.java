package general_work.core;

import java.util.Scanner;

/**
 * Класс для ввода инфорамции
 *
 */
public class View {
    Scanner in = new Scanner(System.in, "Cp866");

    /**
     * метод для ввода строки, принимает строку для отображения нужного параметра
     * 
     * @param title строка с требованием ввода
     * @return возвращет сканер для ввода строки
     */
    public String getString(String title) {
        System.out.printf("%s", title);
        return in.nextLine();
    }

}