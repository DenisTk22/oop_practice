package practice_2.task;

public class Championship {

    public static void main(String[] args) {

        // Бегуны
        Runner[] runners = {
                new Cat("Барсик", 500, 1),
                new Cat("Мася", 2000, 10),
                new Human("Вася", 5000, 10),
                new Human("Дима", 4500, 9),
                new Robot("R2D2", 7000, 15),
                new Robot("CPO13", 7500, 55),
        };

        // Препятствия
        Obstacle[] obstacles = {
                new Track(1200),
                new Wall(2),
                new Track(2000),
                new Wall(1),
                new Track(3000),
                new Wall(3)
        };

        for (Runner runner : runners) {                           // пробегаем по всем участникам
            for (Obstacle obstacle : obstacles) {                  // пробегаем по всем препятствиям
                if (obstacle instanceof Track) {                 // если препятствием является трек, то вызываем метод run
                    if (!runner.run(obstacle.getLength())) {       // если метод run вернет false (!), тогда бегун сходит с трассы
                        break;
                    }
                } else if (obstacle instanceof Wall) {              // если препятствием является стена, то вызываем метод jump
                    if (!runner.jump(obstacle.getHeight())) {
                        break;
                    }
                }
            }
        }
    }
}
