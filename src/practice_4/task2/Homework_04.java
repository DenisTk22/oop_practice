package practice_4.task2;

import java.util.ArrayList;
import java.util.List;

/**
 a. ���� ������ Fruit, Apple extends Fruit, Orange extends Fruit; done
 b. ����� Box, � ������� ����� ���������� ������. ������� ������� ����������� �� ���� ������,
 ������� � ���� ������� ������ ������� � ������, � ���������; done
 c. ��� �������� ������� ������ ������� ����� ������������ ArrayList; done
 d. ������� ����� getWeight(), ������� ����������� ��� �������, ���� ��� ������ ������ � �� ����������:
 ��� ������ � 1.0f, ��������� � 1.5f (������� ��������� �� �����); done
 e. ������ ������ Box ������� ����� compare(), ������� ��������� �������� ������� ������� � ���, �������
 ������� � compare() � �������� ���������. true � ���� �� ����� �����, false � ��������������� ������.
 ����� ���������� ������� � �������� � �����������; done
 f. �������� �����, ������� ��������� ���������� ������ �� ������� ������� � ������.
 ������ ��� ���������� �������: ������ ������ �������� � ������� � �����������.
 ��������������, � ������� ������� ������� �� ��������, � � ������ �������������� �������, ������� ���� � ������;
 g. �� �������� ��� ����� ���������� ������ � �������. done
 */

public class Homework_04 {
    public static void main(String[] args) {

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        Apple apple6 = new Apple();
        Apple apple7 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();
        Orange orange5 = new Orange();
        Orange orange6 = new Orange();

        Box<Apple> boxWithApples1 = new Box<>(); // ��������� - ������ ������
        boxWithApples1.addFruit(apple1);
        boxWithApples1.addFruit(apple2);
        boxWithApples1.addFruit(apple3);
        boxWithApples1.addFruit(apple5);

        Box<Apple> boxWithApples2 = new Box<>();
        boxWithApples2.addFruit(apple4);
        boxWithApples2.addFruit(apple6);
        boxWithApples2.addFruit(apple7);

        Box<Orange> boxWithOrange1 = new Box<>();
        boxWithOrange1.addFruit(orange1);
        boxWithOrange1.addFruit(orange2);

        Box<Orange> boxWithOrange2 = new Box<>();
        boxWithOrange2.addFruit(orange4);
        boxWithOrange2.addFruit(orange5);

// ���������� ������� � ������� ��������
        System.out.println("���������� ������� � ������� ��������");
        System.out.println(boxWithApples1.getWeightBox(apple1.getWeight()));
        System.out.println(boxWithApples2.getWeightBox(apple1.getWeight()));
        System.out.println(boxWithOrange2.getWeightBox(orange1.getWeight()));
        System.out.println(Box.compare((boxWithApples1.getWeightBox(apple1.getWeight())),(boxWithApples2.getWeightBox(apple1.getWeight()))));
        System.out.println(Box.compare((boxWithOrange2.getWeightBox(orange1.getWeight())),(boxWithApples2.getWeightBox(apple1.getWeight()))));

// ��������� �������
        System.out.println("��������� �������");
        System.out.println(boxWithApples1.getWeightBox(apple1.getWeight()));
        System.out.println(boxWithApples2.getWeightBox(apple1.getWeight()));
        boxWithApples1.pourBox1ToBox2(boxWithApples2);
        System.out.println(boxWithApples1.getWeightBox(apple1.getWeight()));
        System.out.println(boxWithApples2.getWeightBox(apple1.getWeight()));
    }
}


abstract class Fruit{
    private final float weight;

    public final float getWeight() {
        return weight;
    }

    public Fruit(float weight) {
        this.weight = weight;
    }
}

class Apple extends Fruit {

    public Apple() {
        super(1.0f); // ����� ��� ������ � ������ ������������
    }
}

class Orange extends Fruit {

    public Orange() {
        super(1.5f);
    }
}

class Box<T extends Fruit> { // ����������� - � ������� ���� ������ ���� ���������
    List<T> fruits = new ArrayList<T>();
    private float weightBox;

    public float getWeightBox(float w) { //
        weightBox = fruits.size() * w;
        return weightBox;
    }

    public void setWeightBox(float weightBox) {
        this.weightBox = weightBox;
    }

    public void addFruit(T p){
        fruits.add(p);
    }

    public static boolean compare(float w1, float w2){
        return w1 == w2;
    }

    public void pourBox1ToBox2(Box<T> a){
        fruits.addAll(a.fruits);
        System.out.printf("�������� �� ������ ������� %s ������\n", a.fruits.size());
        a.fruits.clear();
    }
}
