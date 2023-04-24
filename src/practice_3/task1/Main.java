package practice_3.task1;

import javax.swing.*;

//—оздать классы —обака и  от с наследованием от класса ∆ивотное.
// ¬се животные могут бегать и плыть. ¬ качестве параметра каждому методу передаетс€ длина преп€тстви€.
// –езультатом выполнени€ действи€ будет печать в консоль. (Ќапример, dog1.run(150); -> 'Ѕобик пробежал 150 м.');
// ” каждого животного есть ограничени€ на действи€
// (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
// ƒобавить подсчет созданных котов, собак и животных.
public class Main {

    public static void main(String[] args) { // static пол€ не принадлежат объектам, они принадлежат типам (например Animal)

        Animal[] animals = {
                new Animal.Cat("Ѕарсик", 20, 30),
                new Animal.Cat("ћарсик", 20, 30),
                new Animal.Dog("Ѕарсик", 20, 30),
                new Animal("–ога и копыта", 20, 30),
                new Animal("Ћапы и звост", 20, 30),
        };

        for (Animal animal: animals){
            animal.run(40);
            animal.swim(20);
            animal.run(10);
            animal.swim(5);
            animal.run(20);
            animal.swim(70);
        }

        System.out.printf(" ол-во котов %d\n", Animal.Cat.getCounter());
        System.out.printf(" ол-во собак %d\n", Animal.Dog.getCounter());
        System.out.printf(" ол-во животных %d\n", Animal.getCounter());
    }
}

class Animal{
// переменные класса €вл€ютс€ состо€нием объекта
    protected String name;
    private int maxRun;
    private int maxSwim;
    private static int counter; // дл€ переменных на уровне класса не нужно задавать значени€ по умолчанию, они уже определны (дл€ int = 0, дл€ String = null

    public static int getCounter(){ // если переменна€ закрыта (private) то к ней можно обратитьс€ через метод
        return counter;
    }

// инициализатор, срабытывает при вызове любого конструктора
    {
        counter++;
    }
    public Animal(String name, int maxRun, int maxSwim) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        //counter++;
    }

    public void run(int distance){
        if(distance <= maxRun){
            System.out.printf("%s пробежал %d метров\n", name, distance);
        }
        else {
            System.out.printf("%s не смог пробежать %d метров\n", name, distance);
    }
    }

    public Animal() {

    }

    public void swim(int distance){
        if(distance <= maxSwim){
            System.out.printf("%s пробежал %d метров\n", name, distance);
        }
        else {
            System.out.printf("%s не смог пробежать %d метров\n", name, distance);
        }
    }


    static class Cat extends Animal{
        {
            counter++;
        }
        private static int counter;

        public static int getCounter(){ // если переменна€ закрыта (private) то к ней можно обратитьс€ через метод
            return counter;}

        public Cat(String name, int maxRun, int maxSwim) {
            super(name, maxRun, maxSwim);
        }

        @Override
        public void swim(int distance) {
            System.out.printf("%s не умеет плавать", name);
        }
    }

    static class Dog extends Animal{

        {
            counter++;
        }
        private static int counter;

        public static int getCounter(){ // если переменна€ закрыта (private) то к ней можно обратитьс€ через метод
            return counter;}
        public Dog(String name, int maxRun, int maxSwim) {
            super(name, maxRun, maxSwim);
        }
    }


}