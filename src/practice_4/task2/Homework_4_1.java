package practice_4.task2;

import java.util.*;

public class Homework_4_1 {
    public static void main(String[] args) {

        new Homework_4_1().doWork();

    }

    public void doWork(){

        //#region Task 3

        System.out.println("\n*** ������ ***\n");

        // �������� ������� � 3 �������� ������
        Box<Apple> appleBox1 = new Box<>(
                new Apple(),
                new Apple(),
                new Apple()
        );

        // �������� ������� � 500 �������� ������
        Box<Apple> appleBox2 = new Box<>();
        for (int i = 0; i < 500; i++) {
            appleBox2.add(new Apple());
        }

        // �������� ������� � 2 ����������� ������
        Box<Orange> orangeBox1 = new Box<>(
                new Orange(),
                new Orange()
        );

        // �������� ������� � 500 ����������� ������
        Box<Orange> orangeBox2 = new Box<>();
        for (int i = 0; i < 500; i++) {
            orangeBox2.add(new Orange());
        }

        // ��������� ����� ��� ������� �� ��������:
        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());
        System.out.println(orangeBox1.getWeight());
        System.out.println(orangeBox2.getWeight());
        System.out.println();

        // ��������� ���� �������:
        System.out.println(appleBox1.compare(orangeBox1));

        // ��������� ������ �� ����� ������� � ������:
        orangeBox1.replaceAll(orangeBox2);
        // ���������� ���������� �������:
        System.out.println(orangeBox1.getWeight());
        System.out.println(orangeBox2.getWeight());

        //#endregion

    }

    /**
     * �����������, ������� ����� - ����� (3a)
     */
    public abstract class Fruit {

        private final float weight; // ��� ������ (3d)

        public Fruit(float weight) {
            this.weight = weight;
        }

        public float getWeight() {
            return weight;
        }

    }

    /**
     * ����� ������, ����������� �� �������� ������������ ������ Fruit (3a)
     */
    public class Apple extends Fruit {

        public Apple() {
            super(1.0f); // ��� ������, �� ������ = 1.0f (3d)
        }

    }

    /**
     * ����� ��������, ����������� �� �������� ������������ ������ Fruit (3a)
     */
    public class Orange extends Fruit {

        public Orange() {
            super(1.5f); // ��� ���������, �� ������ = 1.5f (3d)
        }

    }

    /**
     * ���������� (�� ���� ������) ����� "�������" (3b)
     * @param <T> - ��� ������
     */
    public class Box<T extends Fruit> {

        // ��������� ��� �������� ������� (3c)
        LinkedList<T> fruits;

        //#region Constructors

        public Box() {
            this.fruits = new LinkedList<>();
        }

        public Box(Collection<T> fruits) {
            this.fruits = new LinkedList<>(fruits);
        }

        public Box(T... fruits) {
            this.fruits = new LinkedList<>(Arrays.asList(fruits));
        }

        //#endregion

        /**
         * �������� ��� ���� �������, ����������� � ������� (3d)
         * @return - ��� �������
         */
        public double getWeight() {
            if (fruits.size() == 0) return 0;
            // ���-�� ������� (���-�� ��������� ���������) * ��� ������ (����� ����� � ������� ��������)
            return fruits.size() * fruits.get(0).getWeight();
        }

        /**
         * �������� ��� �������, � ��������, ���������� �� ���� ����� ��������� (3e)
         * @param other - ������ �������
         * @return - ��������� ��������� ���� ������� (����������� 0.001)
         */
        public boolean compare(Box<?> other) {
            return Math.abs(getWeight() - other.getWeight()) < 0.001;
        }

        /**
         * ����������� ��� ������ �� ������ ������� � ������� (3f)
         * @param other - ������ �������
         */
        public void replaceAll(Box<T> other) {
            other.getFruits().addAll(fruits);
            fruits.clear();
        }

        /**
         * �������� ��� ������ � ������� (��������������� �����, 3f)
         * @return
         */
        public LinkedList<T> getFruits() {
            return fruits;
        }

        /**
         * ����� ���������� ������ � ������� (3g)
         * @param fruit - �����
         */
        public void add(T fruit) {
            fruits.add(fruit);
        }
    }

}
