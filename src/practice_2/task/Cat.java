package practice_2.task;

public class Cat implements Runner{

    private String name;
    private int maxRun;
    private int maxJump;

    public String getName() { // геттеры, их можно использовать в интерфейсе в методах по умолчанию
        return name;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxJump() {
        return maxJump;
    }
    // так как определены методы по умолчанию в интерфейсе Runner, то аналогичные методы в классах можно убрать
    public Cat(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }


//    @Override
//    public boolean jump(int height) {
//        if (height <= maxJump){
//            System.out.printf("%s успешно перепрыгнул стену\n", name, height);
//            return true;
//        }
//        else{
//            System.out.printf("%s не смог перепрыгнуть", name, height);
//            return false;
//        }
//    }
//
//    @Override
//    public boolean run(int distance) {
//        if (distance <= maxJump){
//            System.out.printf("%s успешно пробежал\n", name, distance);
//            return true;
//        }
//        else{
//            System.out.printf("%s не смог пробежать\n", name, distance);
//            return false;
//        }
//    }
}
