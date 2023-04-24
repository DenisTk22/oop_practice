package practice_3.task1;

import javax.swing.*;

//������� ������ ������ � ��� � ������������� �� ������ ��������.
// ��� �������� ����� ������ � �����. � �������� ��������� ������� ������ ���������� ����� �����������.
// ����������� ���������� �������� ����� ������ � �������. (��������, dog1.run(150); -> '����� �������� 150 �.');
// � ������� ��������� ���� ����������� �� ��������
// (���: ��� 200 �., ������ 500 �.; ��������: ��� �� ����� �������, ������ 10 �.).
// �������� ������� ��������� �����, ����� � ��������.
public class Main {

    public static void main(String[] args) { // static ���� �� ����������� ��������, ��� ����������� ����� (�������� Animal)

        Animal[] animals = {
                new Animal.Cat("������", 20, 30),
                new Animal.Cat("������", 20, 30),
                new Animal.Dog("������", 20, 30),
                new Animal("���� � ������", 20, 30),
                new Animal("���� � �����", 20, 30),
        };

        for (Animal animal: animals){
            animal.run(40);
            animal.swim(20);
            animal.run(10);
            animal.swim(5);
            animal.run(20);
            animal.swim(70);
        }

        System.out.printf("���-�� ����� %d\n", Animal.Cat.getCounter());
        System.out.printf("���-�� ����� %d\n", Animal.Dog.getCounter());
        System.out.printf("���-�� �������� %d\n", Animal.getCounter());
    }
}

class Animal{
// ���������� ������ �������� ���������� �������
    protected String name;
    private int maxRun;
    private int maxSwim;
    private static int counter; // ��� ���������� �� ������ ������ �� ����� �������� �������� �� ���������, ��� ��� ��������� (��� int = 0, ��� String = null

    public static int getCounter(){ // ���� ���������� ������� (private) �� � ��� ����� ���������� ����� �����
        return counter;
    }

// �������������, ����������� ��� ������ ������ ������������
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
            System.out.printf("%s �������� %d ������\n", name, distance);
        }
        else {
            System.out.printf("%s �� ���� ��������� %d ������\n", name, distance);
    }
    }

    public Animal() {

    }

    public void swim(int distance){
        if(distance <= maxSwim){
            System.out.printf("%s �������� %d ������\n", name, distance);
        }
        else {
            System.out.printf("%s �� ���� ��������� %d ������\n", name, distance);
        }
    }


    static class Cat extends Animal{
        {
            counter++;
        }
        private static int counter;

        public static int getCounter(){ // ���� ���������� ������� (private) �� � ��� ����� ���������� ����� �����
            return counter;}

        public Cat(String name, int maxRun, int maxSwim) {
            super(name, maxRun, maxSwim);
        }

        @Override
        public void swim(int distance) {
            System.out.printf("%s �� ����� �������", name);
        }
    }

    static class Dog extends Animal{

        {
            counter++;
        }
        private static int counter;

        public static int getCounter(){ // ���� ���������� ������� (private) �� � ��� ����� ���������� ����� �����
            return counter;}
        public Dog(String name, int maxRun, int maxSwim) {
            super(name, maxRun, maxSwim);
        }
    }


}