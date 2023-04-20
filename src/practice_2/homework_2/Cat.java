package practice_2.homework_2;

public class Cat {
    private String name;
    private int appetite;
    public static boolean satiety; // �������

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void isSatiety(boolean satiety) {
        if (satiety){
            System.out.printf("%s ���\n", name);
        }
        if (!satiety){
            System.out.printf("%s �������\n", name);
        }
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public void eat() {
        System.out.printf("������� � %s %s ��. ��� ����.\n", name, appetite);
    }
}
