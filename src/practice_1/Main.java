package practice_1;

import practice_1.task.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product();
        product1.setBrand("Источник");
        product1.setName("Вода без газа");
        product1.setPrice(100.15);
        //System.out.println(product1.displayInfo());

        Product product2 = new Product("Молоко", 120.25);
        product2.setBrand("Княгининское");
        //System.out.println(product2.displayInfo());

        //product2.price = -60;
        //product2.name = "______";
        //System.out.println(product2.displayInfo());

        Product product3 = new Product("ss", "Bottle of water", 100);
        product3.setPrice(10);
        //System.out.println(product3.displayInfo());


        Product bottleOfWater1 = new BottleOfWater("Бутылка1", 100, 2);
        //System.out.println(bottleOfWater1.displayInfo());

        Product bottleOfMilk1 = new BottleOfMilk("Молоко1", 200, 1, 10);
        //System.out.println(bottleOfMilk1.displayInfo());

        Product bottleOfWater2 = new BottleOfWater("Бутылка2", 100, 1);
        //System.out.println(bottleOfWater2.displayInfo());

        Product bottleOfWater3 = new BottleOfWater("Бутылка3", 100, 2);
        //System.out.println(bottleOfWater3.displayInfo());

        Product bottleOfWater4 = new BottleOfWater("Бутылка4", 100, 2);
        //System.out.println(bottleOfWater4.displayInfo());

        Product chocolate1 = new Chocolate("Добрая душа", "Шоколад1", 548, "черный", "с орехами");
        //System.out.println(chocolate1.displayInfo());

        Product chocolate2 = new Chocolate("Бабаевский", "Шоколад2", 423, "белый", "твердый");
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

//        BottleOfWater bottleOfWaterRes = vendingMachine.getBottleOfWater("Бутылка2", 1);
//
//        if (bottleOfWaterRes != null){
//            System.out.println("\nВы купили: ");
//            System.out.println(bottleOfWaterRes.displayInfo());
//        }
//        else {
//            System.out.println("\nРезультат:\nТакой бутылки нет в автомате.");
//        }
//
//        Chocolate chocolateRes = vendingMachine.getChocolate("Бабаевский", "Шоколад2");
//
//        if (chocolateRes != null){
//            System.out.println("\nВы купили: ");
//            System.out.println(chocolateRes.displayInfo());
//        }
//        else {
//            System.out.println("\nРезультат:\nТакой шоколадки нет в автомате.");
//        }



        Product productRes = vendingMachine.getProduct("Молоко1");


        if (productRes != null){
            System.out.println("\nВы купили: ");
            System.out.println(productRes.displayInfo());
        }
        else{
            System.out.println("\nРезультат:\nТакого товара нет в автомате.");
        }

//        while (true){
//
//        }
    }
}