package practice_1.task;

public class Chocolate extends Product{
    private String type;
    private String admixture;

    public Chocolate(String brand, String name, double price, String type, String admixture) {
        super(brand, name, price);
        this.type = type;
        this.admixture = admixture;
    }

    @Override
    public String displayInfo() {
        //return super.displayInfo();
        return String.format("%s - %s - %s - %s - %s", brand, name, price, type, admixture);
    }
}
