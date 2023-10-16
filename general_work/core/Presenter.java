package general_work.core;

import general_work.exceptions.NullInput;
import general_work.exceptions.WrongSimbolInput;

/**
 * Подготовка и ввод данных в программу
 */
public class Presenter {
    private ParametersSetting ps = new ParametersSetting();

    public Presenter() {
        super();
    }

    /**
     * метод для создания экземпляра класса Toy с помощью ввода данных
     * пристутствуют системы проверки на правильность ввода, на пустую строку,
     * а так же на размер числа от 1 до 9
     * @param index метод принимает index и добавляет его в качестве id игрушки
     * @return возвращает готовый экземляр класса
     */
    public Toy createToy(int index) {
        boolean flag = true;
        int id = index + 1;
        String name = "";
        Integer frequency = 0;

        while (flag) {
            try {
                System.out.println("В наименование игрушки, допускается только ввод русского алфавита");
                name = ps.createName("Введите наименование игрушки: ");
                flag = false;
            } catch (NullInput e) {
                System.out.println(e.getMessage());
            } catch (WrongSimbolInput e) {
                System.out.println(e.getMessage());
            }
        }

        while (!flag) {
            try {
                System.out.println("Частота выпадения игрушки указывается целым числом от 1 до 9");
                frequency = Integer.parseInt(ps.createFrequency("Укажите частоту выпадения игрушки: "));
                if(frequency < 10 && frequency > 0){
                flag = true;
                } else {
                    System.out.println("Число должно быть от 1 до 9 включительно.");
                }
            } catch (NullInput e) {
                System.out.println(e.getMessage());
            } catch (WrongSimbolInput e) {
                System.out.println(e.getMessage());
            }
        }

        Toy toy = new Toy(id, name, frequency);
        toy.printToy();
        return toy;

    }
}