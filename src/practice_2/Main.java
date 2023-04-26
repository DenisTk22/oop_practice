package practice_2;

public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик", "Серый");
        cat1.jump();
        cat1.voice();
        System.out.printf("Имя животного: %s\n", ((Animal)cat1).getName()); // или просто cat1.getName() // Обращение к методу базового класса - upcasting
        //cat1.getName(); //метод определен на уровне класса Animal, так тоже можно

        Cat cat2 = new Cat("Мася", "Рыжая");
        cat2.jump();
        cat2.voice();
        System.out.printf("Имя животного: %s\n", cat2.getName());
        System.out.printf("Окрас животного: %s\n", ((Cat)cat2).getColor()); // downcasting - вызов метода из класса наследника в super классе


        Dog dog1 = new Dog ("Шарик", 9);
        dog1.jump();
        dog1.voice();


        Animal dog2 = new Dog ("Шарик", 9);
        if (dog2 instanceof Dog){
            System.out.printf("Имя животного: %s\n", dog2.getName());
        }

        CatV2 catv2_1 = new CatV2();
        CatV2 catv2_2 = new CatV2();
        DogV2 dogv2_1 = new DogV2();
        Bird bird1 = new Bird();

        Object[] animals = new Object[] {catv2_1, catv2_2, dogv2_1, bird1};

        for (Object animal: animals){
            if (animal instanceof Flyable){
                ((Flyable)animal).fly(15);
            }
        }

    }
}
// интерфейсы - определяют функционал без конкретной реализации, но которые можно описать друних классах

interface  Runnable{
    void swim(int distance);

    void run(int distance);
}

interface  Flyable{
    void fly(int distance);
}
class CatV2 implements Runnable{

    @Override
    public void swim(int distance) {

    }

    @Override
    public void run(int distance) {

    }
}

class DogV2 implements Runnable{

    @Override
    public void swim(int distance) {

    }

    @Override
    public void run(int distance) {

    }
}

class Bird implements Runnable, Flyable{

    @Override
    public void swim(int distance) {

    }

    @Override
    public void run(int distance) {

    }

    @Override
    public void fly(int distance) {
        System.out.println();
    }
}


//абстрактный класс
abstract class Animal {

    public String name;

    public String getName() {
        return name;
    }

    //конструктор
    public Animal(String name) {
        this.name = name;
    }

    public void jump(){
        System.out.println("Животное прыгает.");
    }
    //можно создавать абстракный метод, но в нем нельзя создать логику
    public abstract void voice();
}

//в классе наследнике обязательно нужно переопределять абстрактный метод
class Cat extends Animal{
    private String color;

    public String getColor(){
        return color;
    }

    public Cat(String name, String color) {
        super(name);
        this.color = color;
    }



    @Override
    public void jump() {
        System.out.println("Котик прыгает.");
    }

    @Override
    public void voice() {
        System.out.println("Котик мяукает.");
    }


}

class Dog extends Animal{

    private int weight;

    public int getWeight() {
        return weight;
    }

    public Dog(String name, int weight) {
        super(name);
        this.weight = weight;
    }

    @Override
    public void jump() {
        System.out.println("Собака прыгает.");
    }

    @Override
    public void voice() {
        System.out.println("Собака гавкает.");
    }
}