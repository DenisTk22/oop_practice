package practice_1;

import practice_1.task.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product();
        product1.setBrand("Istochnik");
        product1.setName("Bottle of water");
        product1.setPrice(100.15);
        //System.out.println(product1.displayInfo());

        Product product2 = new Product("Bottle of milk", 120.25);
        product2.setBrand("Knyagininskoe");
        //System.out.println(product2.displayInfo());

        //product2.price = -60;
        //product2.name = "______";
        //System.out.println(product2.displayInfo());

        Product product3 = new Product("ss", "Bottle of water", 100);
        product3.setPrice(10);
        //System.out.println(product3.displayInfo());


        Product bottleOfWater1 = new BottleOfWater("Bottle1", 100, 2);
        System.out.println(bottleOfWater1.displayInfo());

        Product bottleOfMilk1 = new BottleOfMilk("Milk", 200, 1, 10);
        System.out.println(bottleOfMilk1.displayInfo());

        Product bottleOfWater2 = new BottleOfWater("Bottle2", 100, 1);
        System.out.println(bottleOfWater2.displayInfo());

        Product bottleOfWater3 = new BottleOfWater("Bottle3", 100, 2);
        System.out.println(bottleOfWater3.displayInfo());

        Product bottleOfWater4 = new BottleOfWater("Bottle4", 100, 2);
        System.out.println(bottleOfWater4.displayInfo());

        Product chocolate1 = new Chocolate("Dobraya dusha", "Chocolate", 548, "black", "with nuts");
        System.out.println(chocolate1.displayInfo());

        Product chocolate2 = new Chocolate("Babaevskiy", "Chocolate", 423, "white", "solid");
        System.out.println(chocolate2.displayInfo());


        List<Product> products = new ArrayList<>();
        products.add(bottleOfWater1);
        products.add(bottleOfMilk1);
        products.add(bottleOfWater2);
        products.add(bottleOfWater3);
        products.add(bottleOfWater4);
        products.add(chocolate1);
        products.add(chocolate2);


        VendingMachine vendingMachine = new VendingMachine(products);

        BottleOfWater bottleOfWaterRes = vendingMachine.getBottleOfWater("Bottle2", 1);

        if (bottleOfWaterRes != null){
            System.out.println("\nYou bought: ");
            System.out.println(bottleOfWaterRes.displayInfo());
        }
        else {
            System.out.println("\nResult:\nThere is no such bottle in the vending machine.");
        }

        Chocolate chocolateRes = vendingMachine.getChocolate("Babaevskiy", "Chocolate");

        if (chocolateRes != null){
            System.out.println("\nYou bought: ");
            System.out.println(chocolateRes.displayInfo());
        }
        else {
            System.out.println("\nResult:\nThere is no such chocolate in the vending machine.");
        }
    }
}