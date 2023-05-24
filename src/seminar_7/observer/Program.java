package seminar_7.observer;

public class Program {

    /**
     * TODO: 1 ���������� ����������, ���������� � �������� �������������� Observer
     * �������� ����� ��� �����������.
     * **.2 �������� ����� �������� "��������", �������� ������ ��������� ��������.
     * **.3  ���������������� �������� (enum)
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
