package practice_1;

import practice_1.task.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product();
        product1.setBrand("��������");
        product1.setName("���� ��� ����");
        product1.setPrice(100.15);
        //System.out.println(product1.displayInfo());

        Product product2 = new Product("������", 120.25);
        product2.setBrand("������������");
        //System.out.println(product2.displayInfo());

        //product2.price = -60;
        //product2.name = "______";
        //System.out.println(product2.displayInfo());

        Product product3 = new Product("ss", "Bottle of water", 100);
        product3.setPrice(10);
        //System.out.println(product3.displayInfo());


        Product bottleOfWater1 = new BottleOfWater("�������1", 100, 2);
        //System.out.println(bottleOfWater1.displayInfo());

        Product bottleOfMilk1 = new BottleOfMilk("������1", 200, 1, 10);
        //System.out.println(bottleOfMilk1.displayInfo());

        Product bottleOfWater2 = new BottleOfWater("�������2", 100, 1);
        //System.out.println(bottleOfWater2.displayInfo());

        Product bottleOfWater3 = new BottleOfWater("�������3", 100, 2);
        //System.out.println(bottleOfWater3.displayInfo());

        Product bottleOfWater4 = new BottleOfWater("�������4", 100, 2);
        //System.out.println(bottleOfWater4.displayInfo());

        Product chocolate1 = new Chocolate("������ ����", "�������1", 548, "������", "� �������");
        //System.out.println(chocolate1.displayInfo());

        Product chocolate2 = new Chocolate("����������", "�������2", 423, "�����", "�������");
        //System.out.println(chocolate2.displayInfo());


        List<Product> products = new ArrayList<>();
        products.add(bottleOfWater1);
        products.add(bottleOfMilk1);
        products.add(bottleOfWater2);
        products.add(bottleOfWater3);
        products.add(bottleOfWater4);
        products.add(chocolate1);
        products.add(chocolate2);


        //System.out.println(products);


        VendingMachine vendingMachine = new VendingMachine(products);

//        BottleOfWater bottleOfWaterRes = vendingMachine.getBottleOfWater("�������2", 1);
//
//        if (bottleOfWaterRes != null){
//            System.out.println("\n�� ������: ");
//            System.out.println(bottleOfWaterRes.displayInfo());
//        }
//        else {
//            System.out.println("\n���������:\n����� ������� ��� � ��������.");
//        }
//
//        Chocolate chocolateRes = vendingMachine.getChocolate("����������", "�������2");
//
//        if (chocolateRes != null){
//            System.out.println("\n�� ������: ");
//            System.out.println(chocolateRes.displayInfo());
//        }
//        else {
//            System.out.println("\n���������:\n����� ��������� ��� � ��������.");
//        }



        Product productRes = vendingMachine.getProduct("������1");


        if (productRes != null){
            System.out.println("\n�� ������: ");
            System.out.println(productRes.displayInfo());
        }
        else{
            System.out.println("\n���������:\n������ ������ ��� � ��������.");
        }

//        while (true){
//
//        }
    }
}