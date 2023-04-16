package ru.geekbrains;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product();
        //product1.brand = "ООО Источник";
        //product1.name = "Бутылка с водой";
        //product1.price = 100.15;

        System.out.println(product1.displayInfo());

        Product product2 = new Product("Бутылка с молоком", 120.25);
        product2.param2 = "..";
        System.out.println(product2.displayInfo());

        //product2.price = -60;
        //product2.name = "______";
        System.out.println(product2.displayInfo());

        Product product3 = new Product("ss", "__", 100);
        System.out.println(product3.displayInfo());
        product3.setPrice(10);

        Product bottleOfWater1 = new BottleOfWater("Бутылка1", 100, 2);
        Product bottleOfMilk1 = new BottleOfMilk("Молоко", 200, 1, 10);
        Product bottleOfWater2 = new BottleOfWater("Бутылка2", 100, 1);
        Product bottleOfWater3 = new BottleOfWater("Бутылка3", 100, 2);
        Product bottleOfWater4 = new BottleOfWater("Бутылка3", 100, 2);

        String s = "123";
        String aaaa = "123";
        String s1 = new String("123");

        List<Product> products = new ArrayList<>();
        products.add(bottleOfWater1);
        products.add(bottleOfMilk1);
        products.add(bottleOfWater2);
        products.add(bottleOfWater3);
        products.add(bottleOfWater4);

        VendingMachine vendingMachine = new VendingMachine(products);

        BottleOfWater bottleOfWaterRes = vendingMachine.getBottleOfWater("Бутылка2", 1);
        if (bottleOfWaterRes != null){
            System.out.println("Вы купили: ");
            System.out.println(bottleOfWaterRes.displayInfo());
        }
        else {
            System.out.println("Такой бутылки с водой нет в автомате.");
        }

    }
}