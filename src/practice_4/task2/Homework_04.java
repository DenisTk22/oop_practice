package practice_4.task2;

import java.util.ArrayList;
import java.util.List;

/**
 a. ƒаны классы Fruit, Apple extends Fruit, Orange extends Fruit; done
 b.  ласс Box, в который можно складывать фрукты.  оробки условно сортируютс€ по типу фрукта,
 поэтому в одну коробку нельз€ сложить и €блоки, и апельсины; done
 c. ƒл€ хранени€ фруктов внутри коробки можно использовать ArrayList; done
 d. —делать метод getWeight(), который высчитывает вес коробки, зна€ вес одного фрукта и их количество:
 вес €блока Ц 1.0f, апельсина Ц 1.5f (единицы измерени€ не важны); done
 e. ¬нутри класса Box сделать метод compare(), который позвол€ет сравнить текущую коробку с той, которую
 подадут в compare() в качестве параметра. true Ц если их массы равны, false в противоположном случае.
 ћожно сравнивать коробки с €блоками и апельсинами; done
 f. Ќаписать метод, который позвол€ет пересыпать фрукты из текущей коробки в другую.
 ѕомним про сортировку фруктов: нельз€ €блоки высыпать в коробку с апельсинами.
 —оответственно, в текущей коробке фруктов не остаетс€, а в другую перекидываютс€ объекты, которые были в первой;
 g. Ќе забываем про метод добавлени€ фрукта в коробку. done
 */

public class Homework_04 {
    public static void main(String[] args) {

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        Apple apple6 = new Apple();
        Apple apple7 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();
        Orange orange5 = new Orange();
        Orange orange6 = new Orange();

        Box<Apple> boxWithApples1 = new Box<>(); // обобщение - только €блоки
        boxWithApples1.addFruit(apple1);
        boxWithApples1.addFruit(apple2);
        boxWithApples1.addFruit(apple3);
        boxWithApples1.addFruit(apple5);

        Box<Apple> boxWithApples2 = new Box<>();
        boxWithApples2.addFruit(apple4);
        boxWithApples2.addFruit(apple6);
        boxWithApples2.addFruit(apple7);

        Box<Orange> boxWithOrange1 = new Box<>();
        boxWithOrange1.addFruit(orange1);
        boxWithOrange1.addFruit(orange2);

        Box<Orange> boxWithOrange2 = new Box<>();
        boxWithOrange2.addFruit(orange4);
        boxWithOrange2.addFruit(orange5);

// —равниваем коробки с разными фруктами
        System.out.println("—равниваем коробки с разными фруктами");
        System.out.println(boxWithApples1.getWeightBox(apple1.getWeight()));
        System.out.println(boxWithApples2.getWeightBox(apple1.getWeight()));
        System.out.println(boxWithOrange2.getWeightBox(orange1.getWeight()));
        System.out.println(Box.compare((boxWithApples1.getWeightBox(apple1.getWeight())),(boxWithApples2.getWeightBox(apple1.getWeight()))));
        System.out.println(Box.compare((boxWithOrange2.getWeightBox(orange1.getWeight())),(boxWithApples2.getWeightBox(apple1.getWeight()))));

// ѕересыпка фруктов
        System.out.println("ѕересыпка фруктов");
        System.out.println(boxWithApples1.getWeightBox(apple1.getWeight()));
        System.out.println(boxWithApples2.getWeightBox(apple1.getWeight()));
        boxWithApples1.pourBox1ToBox2(boxWithApples2);
        System.out.println(boxWithApples1.getWeightBox(apple1.getWeight()));
        System.out.println(boxWithApples2.getWeightBox(apple1.getWeight()));
    }
}


abstract class Fruit{
    private final float weight;

    public final float getWeight() {
        return weight;
    }

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

class Box<T extends Fruit> { // ограничение - в коробке либо €блоки либо апельсины
    List<T> fruits = new ArrayList<T>();
    private float weightBox;

    public float getWeightBox(float w) { //
        weightBox = fruits.size() * w;
        return weightBox;
    }

    public void setWeightBox(float weightBox) {
        this.weightBox = weightBox;
    }

    public void addFruit(T p){
        fruits.add(p);
    }

    public static boolean compare(float w1, float w2){
        return w1 == w2;
    }

    public void pourBox1ToBox2(Box<T> a){
        fruits.addAll(a.fruits);
        System.out.printf("ƒобавили из другой коробки %s фрукта\n", a.fruits.size());
        a.fruits.clear();
    }
}
