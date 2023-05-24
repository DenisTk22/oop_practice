package seminar_7.observer;

public class Program {

    /**
     * TODO: 1 Доработать приложение, поработать с шаблоном проектирования Observer
     * добавить новый тип сооискателя.
     * **.2 Добавить новую сущность "Вакансия", компания должна рассылать вакансии.
     * **.3  Предусмотретьтип вакансии (enum)
     * @param args
     */
    public static void main(String[] args) {
        JobAgency jobAgency = new JobAgency();

        Company geekBrains = new Company("GeekBrains", 70000, jobAgency);
        Company google = new Company("Google", 100000, jobAgency);
        Company yandex = new Company("Yandex", 120000, jobAgency);

        Master ivanov = new Master("Ivanov");
        Master petrov = new Master("Petrov");
        Student sidirov = new Student("Sidorov");

        jobAgency.registerObserver(ivanov);
        jobAgency.registerObserver(petrov);
        jobAgency.registerObserver(sidirov);

        for (int i = 0; i < 10; i++){
            geekBrains.needEmployee();
            google.needEmployee();
            yandex.needEmployee();
        }

    }
}
