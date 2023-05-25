package seminar_7.observer;

public class Junior implements Observer{
    private String name;
    private double salary;

    public Junior(String name) {
        this.name = name;
        salary = 50000;
    }

    @Override
    public void receiveOffer(String nameCompany, double salary, Vacancy vacancy) {
        if (this.salary < vacancy.getVacancySalary()){
            System.out.printf("Выпускник GB %s >>> Мне нужна эта работа! [%s - %s - %f]\n",
                    name, nameCompany, vacancy.getVacancyName(), vacancy.getVacancySalary());
            this.salary = vacancy.getVacancySalary();
        }
        else {
            System.out.printf("Выпускник GB %s >>> Я найду работу получше [%s - %s - %f]\n",
                    name, nameCompany, vacancy.getVacancyName(), vacancy.getVacancySalary());
        }
    }
}
