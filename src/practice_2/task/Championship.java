package practice_2.task;

public class Championship {

    public static void main(String[] args) {

        // ������
        Runner[] runners = {
                new Cat("������", 500, 1),
                new Cat("����", 2000, 10),
                new Human("����", 5000, 10),
                new Human("����", 4500, 9),
                new Robot("R2D2", 7000, 15),
                new Robot("CPO13", 7500, 55),
        };

        // �����������
        Obstacle[] obstacles = {
                new Track(1200),
                new Wall(2),
                new Track(2000),
                new Wall(1),
                new Track(3000),
                new Wall(3)
        };

        for (Runner runner : runners) {                           // ��������� �� ���� ����������
            for (Obstacle obstacle : obstacles) {                  // ��������� �� ���� ������������
                if (obstacle instanceof Track) {                 // ���� ������������ �������� ����, �� �������� ����� run
                    if (!runner.run(obstacle.getLength())) {       // ���� ����� run ������ false (!), ����� ����� ������ � ������
                        break;
                    }
                } else if (obstacle instanceof Wall) {              // ���� ������������ �������� �����, �� �������� ����� jump
                    if (!runner.jump(obstacle.getHeight())) {
                        break;
                    }
                }
            }
        }
    }
}
