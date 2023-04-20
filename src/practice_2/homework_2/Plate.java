package practice_2.homework_2;

public class Plate {
    private int food;
    static int fullPlate = 100;

    public int getFood() {
        return food;
    }
    public boolean setFood(int food) {
        if (food >= 0) {
            this.food = food;
            System.out.printf("In the plate now %s gr.\n", food);
            return true;
        }
        else{
            this.food = getFood();
            System.out.printf("In the plate still %s gr. The cat ate nothing.\n", getFood());
            return false;
        }
    }

    public void addFood(){
        if (food < fullPlate){
            food = fullPlate;
            System.out.println("The plate is full now!");
        }
    }

    public Plate(int food) {
        this.food = food;
    }
    public void info() {
        System.out.printf("In the plate %s gr.\n", getFood());
    }
}
