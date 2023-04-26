package practice_4.task2;

import java.util.ArrayList;
import java.util.List;


/**
 a. ƒаны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 b.  ласс Box, в который можно складывать фрукты.  оробки условно сортируютс€ по типу фрукта,
 поэтому в одну коробку нельз€ сложить и €блоки, и апельсины;
 c. ƒл€ хранени€ фруктов внутри коробки можно использовать ArrayList;
 d. —делать метод getWeight(), который высчитывает вес коробки, зна€ вес одного фрукта и их количество:
 вес €блока Ц 1.0f, апельсина Ц 1.5f (единицы измерени€ не важны);
 e. ¬нутри класса Box сделать метод compare(), который позвол€ет сравнить текущую коробку с той, которую
 подадут в compare() в качестве параметра. true Ц если их массы равны, false в противоположном случае.
 ћожно сравнивать коробки с €блоками и апельсинами;
 f. Ќаписать метод, который позвол€ет пересыпать фрукты из текущей коробки в другую.
 ѕомним про сортировку фруктов: нельз€ €блоки высыпать в коробку с апельсинами.
 —оответственно, в текущей коробке фруктов не остаетс€, а в другую перекидываютс€ объекты, которые были в первой;
 g. Ќе забываем про метод добавлени€ фрукта в коробку.
 */
public class Homework_4 {
    public static void main(String[] args) {
        Box<Apple> boxWithApples1 = new Box<>(); // обобщение - только €блоки
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
        super(1.0f); // зашит вес €блока в пустом конструкторе
    }
}

class Orange extends Fruit {

    public Orange() {
        super(1.5f);
    }
}

class Box<T extends Fruit>{ // ограничение - в коробке либо €блоки либо апельсины
    ArrayList<T> fruits;
    private float weightBox;

    public float getWeightBox(ArrayList<T> wb) {
        return weightBox;
    }
}
