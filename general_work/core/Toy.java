package general_work.core;

/**
 * Класс, позволяющий создавать объекты с типом игрушка
 */
public class Toy {
    private Integer id;
    private String name;
    private Integer frequency;


    /**
     * Базовый конструктор класса
     * @param id уникальный идентификатор игрушки
     * @param name наименоваие игрушки
     * @param frequency частота выпадения игрушки
     */
    public Toy(Integer id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void printToy(){
        System.out.println("добавлена игрушка с ID: " + id + ", наименование: " + name + ", частота выпадения: " + frequency);
    }
}