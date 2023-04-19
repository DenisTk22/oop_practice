package practice_1.task;

import java.util.List;

public class VendingMachine {

    private final List<Product> products;

    public VendingMachine(List<Product> products) {
        this.products = products;
    }

    public BottleOfWater getBottleOfWater(String name, int volume){
        for (Product product: products) {
            if (product instanceof BottleOfWater){
                BottleOfWater bottle = ((BottleOfWater)product);
                if (bottle.name.equals(name) && bottle.getVolume() == volume)
                    return bottle;
            }
        }
        return null;
    }

    public Chocolate getChocolate(String brand, String name){
        for (Product product: products) {
            if (product instanceof Chocolate){
                Chocolate choco = ((Chocolate)product);
                if (choco.brand.equals(brand) && choco.name.equals(name))
                    return choco;
            }
        }
        return null;
    }

    public Product getProduct(String name){
        for (Product product: products) {
            if (product != null){
                Product goods = ((Product) product);
                if (goods.name.equals(name)) return goods;
            }
        }
        return null;
    }
}
