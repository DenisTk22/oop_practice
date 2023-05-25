package seminar_7.observer;

public class Program {

    /**
     * TODO: 1 Доработать приложение, поработать с шаблоном проектирования Observer
     * добавить новый тип сооискателя.
     * **.2 Добавить новую сущность "Вакансия", компания должна рассылать вакансии.
     * **.3  Предусмотреть тип вакансии (enum)
     * @param args
     */
    public static void main(String[] args) {
        JobAgency jobAgency = new JobAgency();

        Company geekBrains = new Company("GeekBrains", 60000, jobAgency);
        Company google = new Company("Google", 100000, jobAgency);
        Company yandex = new Company("Yandex", 120000, jobAgency);

        Master ivanov = new Master("Ivanov");
        Master petrov = new Master("Petrov");
        Student sidorov = new Student("Sidorov");
        Junior sabakevich = new Junior("Sabakevich");

        Vacancy frontendDev = new Vacancy("FrontendDev", 110000);
        Vacancy backendDev = new Vacancy("BackendDev", 130000);
        Vacancy teacherJava = new Vacancy("TeacherJava", 70000);

        jobAgency.registerObserver(ivanov);
        jobAgency.registerObserver(petrov);
        jobAgency.registerObserver(sidorov);
        jobAgency.registerObserver(sabakevich);

        for (int i = 0; i < 2; i++){
            geekBrains.needEmployee(teacherJava);
            google.needEmployee(backendDev);
            yandex.needEmployee(frontendDev);
        }
    }
}
