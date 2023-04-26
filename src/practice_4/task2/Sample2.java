package practice_4.task2;

import org.w3c.dom.css.CSSStyleDeclaration;

public class Sample2 {

    public static void main(String[] args) {

        DebettAccount<Entity> entityDebettAccount1 =
                new DebettAccount<>(new Entity("���� � ������", "123654535"), 20000000);

        CraditAccount<Person> personCraditAccount1 =
                new CraditAccount<>(new Person("������", "������", "4568984"),2000);

        System.out.println(personCraditAccount1);
        System.out.println(entityDebettAccount1);
        System.out.println("--------------------------");

        Transaction<Account<?>> transaction1 = new Transaction<>(entityDebettAccount1, personCraditAccount1, 20000);
        transaction1.execute();

        transaction1 = new Transaction<>(entityDebettAccount1, personCraditAccount1, 30000);
        transaction1.execute();

    }
}

class Transaction<T extends Account<? extends PersonalData>>{ //����������� Account, ? - �������������� ���� ��� ����������� ��������� ������ ������� �����������

    private final T from;
    private final T to;
    private final double amount;

    public Transaction(T from, T to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void execute(){
        if(from.getAmount() >= amount){
            System.out.printf("��� ����������� ������� ������� ����� �������, �� ����� %.2f ������\n", amount);
            System.out.printf("���� ��������: %s: %.2f ���.\n���� ����������: %s: %.2f ���.\n",
                    from.getData(), from.getAmount(), to.getData(), to.getAmount());
            from.setAmount(from.getAmount() - amount);
            to.setAmount(to.getAmount() + amount);
            System.out.println("������� ��������� ������:");
            System.out.println(from);
            System.out.println(to);
        }
        else {
            System.out.println("������������ ������� �� �����.");
        }
    }
}

class DebettAccount<T extends PersonalData> extends Account<T>{
    public DebettAccount(T data, double amount) {
        super(data, amount);
    }
}

class CraditAccount<T extends PersonalData> extends Account<T>{
    public CraditAccount(T data, double amount) {
        super(data, amount);
    }
}

interface PersonalData{
    String getINN();
}

abstract class Account<T extends PersonalData>{ //� ������� ��������� ����� ��������� ����������� Accont, ����������� extends PersonalData
    private final T data;
    private double amount;

    public T getData() {
        return data;
    }

    public double getAmount() {
        return amount;
        //data.getINN(); // �.� ���� extends PersonalData
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account(T data, double amount) {
        this.data = data;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%s; %.2f ���.", data, amount );
    }
}

/**
 * ���������� ����
 */
class Person implements PersonalData{

    private final String lastName;
    private final String firstName;
    private final String inn;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getINN() {
        return inn;
    }

    public Person(String lastName, String firstName, String inn) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.inn = inn;
    }

    @Override
    public String toString() {
        return String.format("%s %s, ��� %s", lastName, firstName, inn);
    }
}



/**
 * ����������� ����
 */

class Entity implements PersonalData{
    private final String name;
    private final String inn;

    public Entity(String name, String inn) {
        this.name = name;
        this.inn = inn;
    }

    public String getName() {
        return name;
    }

    public String getINN() {
        return inn;
    }
    @Override
    public String toString() {
        return String.format("%s", name);
    }
}
