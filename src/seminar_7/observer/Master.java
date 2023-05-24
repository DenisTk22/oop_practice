package seminar_7.observer;

public class Master implements Observer{

    private String name;
    private double salary;

    public Master(String name) {
        this.name = name;
        salary = 80000;
    }

    @Override
    public void receiveOffer(String nameCompany, double salary) {
        if (this.salary < salary){
            System.out.printf("Специалист %d >>> Мне нужна эта работа! [%s - %f]\n",
                    name, nameCompany, salary);
            this.salary = salary;
        }
        else {
            System.out.printf("Специалист %d >>> Я найду работу получше [%s - %f]\n",
                    name, nameCompany, salary);
        }
    }
}
