package practice_2.homework_2;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("������", 70, false);

        Cat[] cats = {
                new Cat("������", 25, false),
                new Cat("��������", 65, false),
                new Cat("������", 15, false),
        };

        Plate plate = new Plate(Plate.fullPlate);

        plate.info();
//        cat.eat();
//        cat.isSatiety(plate.setFood(plate.getFood() - cat.getAppetite()));
//        cat.eat();
//        cat.isSatiety(plate.setFood(plate.getFood() - cat.getAppetite()));
//        plate.addFood();
//        plate.info();
//        cat.eat();
//        cat.isSatiety(plate.setFood(plate.getFood() - cat.getAppetite()));
//        plate.info();


        for (Cat kitty : cats) {
            kitty.eat();
            kitty.isSatiety(plate.setFood(plate.getFood() - kitty.getAppetite()));
        }

        plate.info();
        plate.addFood();
        plate.info();
    }
}
