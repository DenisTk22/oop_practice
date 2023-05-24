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
            System.out.printf("������� %d >>> ��� ����� ��� ������! [%s - %f]\n",
                    name, nameCompany, salary);
                 this.salary = salary;
        }
        else {
            System.out.printf("������� %d >>> � ����� ������ ������� [%s - %f]\n",
                    name, nameCompany, salary);
        }
    }
}