package practice_3.task2;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sample2 {

    public static Random random = new Random();
    
    //����� generateEmployee() ��� ������������ ���������� ��������
    public static Employee generateEmployee(){

        String [] names = new String[] {"��������", "����", "����", "������", "������", "����", "���������", "�����", "��������", "����"};
        String [] surnames = new String[] {"��������", "���������", "�������", "������", "�����", "�������", "�������", "��������", "������", "������"};
        String [] comments = new String[] {"�������", "�������, ���� ���", "����� ��������", "��������� 80% ���� ������", "��������� 20% ���� ������",
                                           "� ������� ������ ��� ����� �� �����", "������ ��������", "��������� � ����� ������ �������", "����� ���� � �����", "�������� ���"};
        int birthyear = Sample2.random.nextInt(1980, 2020);

        int [] typeEmployee = new int[] {1, 2};

        int salary = random.nextInt(900, 1500);
        int salaryIndex = random.nextInt(28, 31);

        int rate = Sample2.random.nextInt(200, 500);
        int hoursWorking = Sample2.random.nextInt(3, 8);
        int daysWorking = Sample2.random.nextInt(3, 20);
        double salaryF = rate * hoursWorking * daysWorking;

        int typeEmp = typeEmployee[random.nextInt(2)];

        if (typeEmp == 1) {
            return new Worker(names[random.nextInt(10)], surnames[random.nextInt(10)], birthyear, salary*salaryIndex, comments[random.nextInt(10)]);
        }
        else {
            return new Freelancer(names[random.nextInt(10)], surnames[random.nextInt(10)],  birthyear, salaryF, comments[random.nextInt(10)]);
        }
    }



    public static void main(String[] args) {

//        Worker worker = new Worker("����", "���������", 120000);
//        System.out.println(worker);

// ��������� ������ ���������� � �������� ������ �����������
        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++){
            employees[i] = generateEmployee();
        }

        //����� ������ ������� �� �����:
        for (Employee employee: employees){
            System.out.println(employee);
        }


// ���������� � �������������� ������ Comparator:
        Arrays.sort(employees, new BirthYearComparator());

        // ���������� � �������������� ���������� Comparable, ������������������� � ������� Employee:
        //Arrays.sort(employees);


        System.out.println("\n*** Sorted list of employees: ***\n");

        for (Employee employee: employees){
            System.out.println(employee);
        }

    }
}

//�������� ������ SalaryComparator �� ���� ���������� Comparator ��� ���������� ������ ������ Employee
class SalaryComparator implements Comparator<Employee>{

    //������� ���������:
    //���� �1 ������ �2 -->1
    //���� ������� ����� -->0
    //���� �1 ������ �2 -->-1
    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.calculateSalary(), o2.calculateSalary()); // ���� ����� � ������ ������������������, �� ����� �1 �������� ������� �2

        // �������� ������ ������ compare:
        //return o1.calculateSalary()==o2.calculateSalary() ? 0: //���������� ��� if
                //(o1.calculateSalary() > o2.calculateSalary() ? 1 : -1); //���������� ��� if / else
    }
}

// ����� ��� ���������� ���������� �� �������:
class SurNameComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.surName.compareTo(o2.surName);
    }
}
//��������� �� ���� ��������:
class BirthYearComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.birthYear, o2.birthYear);
    }
}



abstract class Employee{ //implements Comparable<Employee>{ // ����������������� ���������� Comparable

    protected String firstName;
    protected String surName;
    protected int birthYear;
    protected double salary;
    protected String comment;

    public Employee(String firstName, String surName, int birthYear, double salary, String comment) {
        this.firstName = firstName;
        this.surName = surName;
        this.birthYear = birthYear;
        this.salary = salary;
        this.comment = comment;
    }

    public abstract double calculateSalary();


    @Override
    public String toString() {
        return String.format("���������: %s %s; ��� ��������: %s; ������: %.2f; ������� �������� ��������: %.2f; �����������: %s",
                surName, firstName, birthYear, salary, calculateSalary(), comment);
    }
}

class Worker extends Employee{

    public Worker(String firstName, String surName, int birthYear, double salary, String comment) {
        super(firstName, surName, birthYear, salary, comment);
    }

    @Override
    public double calculateSalary() {
        int salaryRate = Sample2.random.nextInt(900, 1500);
        int salaryIndex = Sample2.random.nextInt(28, 31);
        return salary = salaryRate * salaryIndex;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Worker; ��� ��������: %s; ������� �������� ��������: %.2f; �����������: %s",
                surName, firstName, birthYear, calculateSalary(), comment);
    }

//    @Override
//    public int compareTo(Employee o) {
//        return Double.compare(this.calculateSalary(), o.calculateSalary());
    //}
}

class Freelancer extends Employee{
    public Freelancer(String firstName, String surName, int birthYear, double salary, String comment) {
        super(firstName, surName, birthYear, salary, comment);
    }

    @Override
    public double calculateSalary() {

        int rate = Sample2.random.nextInt(200, 500);
        int hoursWorking = Sample2.random.nextInt(3, 8);
        int daysWorking = Sample2.random.nextInt(3, 20);
        return salary = rate * hoursWorking * daysWorking;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Freelancer; ��� ��������: %s; ���������� ����� �� �����: %.2f; �����������: %s",
                surName, firstName, birthYear, calculateSalary(), comment);
    }

//    @Override
//    public int compareTo(Employee o) {
//        return Double.compare(this.calculateSalary(), o.calculateSalary());
//    }
}

