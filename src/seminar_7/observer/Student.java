package seminar_7.observer;

public class Student implements Observer{

    private String name;
    private double salary;

    public Student(String name) {
        this.name = name;
        salary = 5000;
    }

    @Override
    public void receiveOffer(String nameCompany, double salary) {
        if (this.salary < salary){
            System.out.printf("Стедент %d >>> Мне нужна эта работа! [%s - %f]\n",
                    name, nameCompany, salary);
                 this.salary = salary;
        }
        else {
            System.out.printf("Стедент %d >>> Я найду работу получше [%s - %f]\n",
                    name, nameCompany, salary);
        }
    }
}
