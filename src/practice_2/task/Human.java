package practice_2.task;

public class Human implements Runner{

    private String name;
    private int maxRun;
    private int maxJump;

    public String getName() {
        return name;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public Human(String name, int maxRun, int maxJump) {
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
