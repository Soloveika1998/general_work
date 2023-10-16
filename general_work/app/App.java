package general_work.app;

import java.util.ArrayList;
import java.util.PriorityQueue;

import general_work.core.MyQueue;
import general_work.core.ParametersSetting;
import general_work.core.Presenter;
import general_work.core.Toy;
import general_work.core.View;

/**
 * Класс программы собирающий нужные методы
 * реализуется с помощью конструкции switch-case
 * 
 */
public class App {
    ParametersSetting ps = new ParametersSetting();
    Presenter p = new Presenter();
    View view = new View();
    MyQueue mq = new MyQueue();

    /**
     * Метод старт для запуска программы, вызывается из класса Program
     */
    public void start() {
        ArrayList<Toy> toys = new ArrayList<>();

        boolean flag = true;
        int index = 0;
        int choice = 0;
        int choice2 = 1;
        while (choice != 2) {
            System.out.println("Выберите действие: \n1. Добавить игрушки (не менее трех) \n2. Выход");
            String str = view.getString("Пожалуйста введите желаемое значение 1/2: ");
            if (ps.isNumber(str)) {
                choice = Integer.parseInt(str);
            }
            choice2 = 1;
            switch (choice) {
                case 1:
                    while (choice2 != 2) {
                        flag = true;
                        if (index < 2) {
                            while (index < 2) {
                                toys.add(p.createToy(index));
                                index++;
                            }
                        } else if (choice2 == 1) {
                            toys.add(p.createToy(index));
                            index++;

                            while (flag) {
                                System.out.println(
                                        "Выберите действие: \n1. Добавить ещё одну игрушку \n2. Возврат в меню");
                                str = view.getString("Пожалуйста введите желаемое значение 1/2: ");
                                if (ps.isNumber(str)) {
                                    choice2 = Integer.parseInt(str);
                                    if (choice2 == 1 || choice2 == 2) {
                                        flag = false;
                                    } else {
                                        System.out.println("Повторите ввод, выбрано не корректное значение");
                                    }
                                } else {
                                    System.out.println("Повторите ввод, выбрано не корректное значение");
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Выход...");
                    break;
                default:
                    System.out.println("Неверный выбор, значение должно быть числом 1, или 2.");
            }
        }

        if (toys.size() >= 3)

        {
            PriorityQueue<Toy> queue = new PriorityQueue<>((t1, t2) -> t2.getFrequency()
                    - t1.getFrequency());
            for (Toy toy : toys) {
                queue.offer(toy);
            }

            mq.getQueue(queue);
        } else {
            System.out.println("Должно быть не менее трех игрушек для создания очереди.");
        }
    }
}