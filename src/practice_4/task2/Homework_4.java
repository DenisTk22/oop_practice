package practice_4.task2;

import java.util.ArrayList;
import java.util.List;


/**
 a. ���� ������ Fruit, Apple extends Fruit, Orange extends Fruit;
 b. ����� Box, � ������� ����� ���������� ������. ������� ������� ����������� �� ���� ������,
 ������� � ���� ������� ������ ������� � ������, � ���������;
 c. ��� �������� ������� ������ ������� ����� ������������ ArrayList;
 d. ������� ����� getWeight(), ������� ����������� ��� �������, ���� ��� ������ ������ � �� ����������:
 ��� ������ � 1.0f, ��������� � 1.5f (������� ��������� �� �����);
 e. ������ ������ Box ������� ����� compare(), ������� ��������� �������� ������� ������� � ���, �������
 ������� � compare() � �������� ���������. true � ���� �� ����� �����, false � ��������������� ������.
 ����� ���������� ������� � �������� � �����������;
 f. �������� �����, ������� ��������� ���������� ������ �� ������� ������� � ������.
 ������ ��� ���������� �������: ������ ������ �������� � ������� � �����������.
 ��������������, � ������� ������� ������� �� ��������, � � ������ �������������� �������, ������� ���� � ������;
 g. �� �������� ��� ����� ���������� ������ � �������.
 */
public class Homework_4 {
    public static void main(String[] args) {
        Box<Apple> boxWithApples1 = new Box<>(); // ��������� - ������ ������
        Box<Apple> boxWithApples2 = new Box<>();
        Box<Orange> boxWithOrange1 = new Box<>();
        Box<Orange> boxWithOrange2 = new Box<>();


        Apple apple1 = new Apple();

        //apple1.getWeight();

    }
}

abstract class Fruit{
    private final float weight;

    public float getWeight() {
        return weight;
    }

    //    public <T> float getWeight(ArrayList<T> fr) {
//        if (Apple){
//            weight = fr.size();
//        }
//        return weight;
//
//    }

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

class Box<T extends Fruit>{ // ����������� - � ������� ���� ������ ���� ���������
    ArrayList<T> fruits;
    private float weightBox;

    public float getWeightBox(ArrayList<T> wb) {
        return weightBox;
    }
}
