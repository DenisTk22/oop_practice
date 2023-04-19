package practice_2.task;

public interface Runner {

    String getName(); // задаем метода поля интерфейса, чтобы использовать в методах по умолчанию

    int getMaxRun();

    int getMaxJump();

    /**
     * Прыжок
     *
     * @param height высота прыжка
     * @return результат прыжка
     */


    default boolean jump(int height) { //метод по умолчанию
        if (height <= getMaxJump()) {
            System.out.printf("%s успешно перепрыгнул стену высотой %s м.\n", getName(), height);
            return true;
        } else {
            System.out.printf("%s не смог перепрыгнуть через стену %s м. Остался на месте.\n", getName(), height);
            return false;
        }
    }

    default boolean run(int distance) { // метод по умолчанию
        if (distance <= getMaxRun()) {
            System.out.printf("%s успешно пробежал дистанцию %s м.\n", getName(), distance);
            return true;
        } else {
            System.out.printf("%s не смог пробежать дистанцию %s м.\n", getName(), distance);
            return false;
        }
    }
}



