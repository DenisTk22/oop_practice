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
            System.out.printf("� ������� �������� %s ��.\n", food);
            return true;
        }
        else{
            this.food = getFood();
            System.out.printf("� ������� �������� %s ��. ��� ������ �� ����.\n", getFood());
            return false;
        }
    }

    public void addFood(){
        if (food < fullPlate){
            food = fullPlate;
            System.out.println("������� ���������!");
        }
    }

    public Plate(int food) {
        this.food = food;
    }
    public void info() {
        System.out.printf("� ������� %s ��.\n", getFood());
    }
}
