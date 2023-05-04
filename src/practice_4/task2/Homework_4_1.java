package practice_4.task2;

import java.util.*;

public class Homework_4_1 {
    public static void main(String[] args) {

        new Homework_4_1().doWork();

    }

    public void doWork(){

        //#region Task 3

        System.out.println("\n*** Фрукты ***\n");

        // Создадим коробку с 3 яблоками внутри
        Box<Apple> appleBox1 = new Box<>(
                new Apple(),
                new Apple(),
                new Apple()
        );

        // Создадим коробку с 500 яблоками внутри
        Box<Apple> appleBox2 = new Box<>();
        for (int i = 0; i < 500; i++) {
            appleBox2.add(new Apple());
        }

        // Создадим коробку с 2 апельсинами внутри
        Box<Orange> orangeBox1 = new Box<>(
                new Orange(),
                new Orange()
        );

        // Создадим коробку с 500 апельсинами внутри
        Box<Orange> orangeBox2 = new Box<>();
        for (int i = 0; i < 500; i++) {
            orangeBox2.add(new Orange());
        }

        // Отобразим общий вес фруктов по коробкам:
        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());
        System.out.println(orangeBox1.getWeight());
        System.out.println(orangeBox2.getWeight());
        System.out.println();

        // Сравнение веса коробок:
        System.out.println(appleBox1.compare(orangeBox1));

        // Переложим фрукты из одной коробки в другую:
        orangeBox1.replaceAll(orangeBox2);
        // Результаты сортировки фруктов:
        System.out.println(orangeBox1.getWeight());
        System.out.println(orangeBox2.getWeight());

        //#endregion

    }

    /**
     * Абстрактный, базовый класс - фрукт (3a)
     */
    public abstract class Fruit {

        private final float weight; // Вес фрукта (3d)

        public Fruit(float weight) {
            this.weight = weight;
        }

        public float getWeight() {
            return weight;
        }

    }

    /**
     * Класс яблоко, унаследован от базового абстрактного класса Fruit (3a)
     */
    public class Apple extends Fruit {

        public Apple() {
            super(1.0f); // Вес яблока, по задаче = 1.0f (3d)
        }

    }

    /**
     * Класс апельсин, унаследован от базового абстрактного класса Fruit (3a)
     */
    public class Orange extends Fruit {

        public Orange() {
            super(1.5f); // Вес апельсина, по задаче = 1.5f (3d)
        }

    }

    /**
     * Обобщенный (по типу фрукта) класс "коробка" (3b)
     * @param <T> - тип фрукта
     */
    public class Box<T extends Fruit> {

        // Коллекция для хранения фруктов (3c)
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
         * Получить вес всех фруктов, находящихся в коробке (3d)
         * @return - вес фруктов
         */
        public double getWeight() {
            if (fruits.size() == 0) return 0;
            // Кол-во фруктов (кол-во элементов коллекции) * вес фрукта (можем взять с первого элемента)
            return fruits.size() * fruits.get(0).getWeight();
        }

        /**
         * Сравнить вес коробки, с коробкой, подаваемой на вход ввиде параметра (3e)
         * @param other - другая коробка
         * @return - результат сравнения веса коробок (погрешность 0.001)
         */
        public boolean compare(Box<?> other) {
            return Math.abs(getWeight() - other.getWeight()) < 0.001;
        }

        /**
         * Переместить все фрукты из другой коробки в текущую (3f)
         * @param other - другая коробка
         */
        public void replaceAll(Box<T> other) {
            other.getFruits().addAll(fruits);
            fruits.clear();
        }

        /**
         * Получить все фрукты в коробке (вспомогательный метод, 3f)
         * @return
         */
        public LinkedList<T> getFruits() {
            return fruits;
        }

        /**
         * Метод добавления фрукта в коробку (3g)
         * @param fruit - фрукт
         */
        public void add(T fruit) {
            fruits.add(fruit);
        }
    }

}
