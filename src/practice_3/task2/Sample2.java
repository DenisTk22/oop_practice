package practice_3.task2;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sample2 {

    public static Random random = new Random();

    //дз2 - Доработать метод generateEmployee(). Метод должен возвращать
    //любого случайного сотрудника разного типа (Worker, Freelancer)

    //метод generateEmployee() для формирования случайного рабочего
    public static Worker generateEmployee(){

        String [] names = new String[] {"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Клим", "Панкратий", "Рубен", "Дементий", "Енот"};
        String [] surnames = new String[] {"Полоскун", "Вассерман", "Никитин", "Козлов", "Шубин", "Волоков", "Копылов", "Семачков", "Лыткин", "Соклов"};
        String [] comments = new String[] {"опоздун", "трудяга, чтоб его", "любит приврать", "выполняет 80% всей работы", "выполняет 20% всей работы",
                                           "в прошлом месяце его никто не видел", "лучший работник", "уважаемый в узких кругах человек", "любит кофе с ромом", "странный тип"};
        int birthyear = Sample2.random.nextInt(1980, 2020);

        int [] typeEmployee = new int[] {1, 2};
//        int salary = random.nextInt(900, 1500);
//        int salaryIndex = random.nextInt(28, 31);


        int typeEmp = typeEmployee[random.nextInt(2)];

        if (typeEmp == 1) {
            return new Worker(names[random.nextInt(10)], surnames[random.nextInt(10)],  "Worker", birthyear, calculateSalary(), comments[random.nextInt(10)]);
        }
        else return new Freelancer(names[random.nextInt(10)], surnames[random.nextInt(10)],  "Worker", birthyear, generateEmployee().calculateSalary(), comments[random.nextInt(10)]);
    }

    public static void main(String[] args) {

//        Worker worker = new Worker("Глеб", "Григорьев", 120000);
//        System.out.println(worker);

// Генерация нового сотрудника и создания списка сотрудников
        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++){
            employees[i] = generateEmployee();
        }

        //Вывод списка рабочих на экран:
        for (Employee employee: employees){
            System.out.println(employee);
        }


// Сортировка с использованием метода Comparator:
        //Arrays.sort(employees, new SalaryComparator());

        // Сортировка с использованием интерфейса Comparable, имплементированного к калассу Employee:
        Arrays.sort(employees);


        System.out.println("\n*** Sorted list of employees: ***\n");

        for (Employee employee: employees){
            System.out.println(employee);
        }

    }
}

//Создание класса SalaryComparator на базе интерфейса Comparator для сортировки нашего списка Employee
class SalaryComparator implements Comparator<Employee>{

    //принцып сравнения:
    //если о1 больше о2 -->1
    //если объекты равны -->0
    //если о1 меньше о2 -->-1
    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.calculateSalary(), o2.calculateSalary()); // если нужно в другой последовательности, то нужно о1 поменять местами о2

        // описание работы метода compare:
        //return o1.calculateSalary()==o2.calculateSalary() ? 0: //сокращение для if
                //(o1.calculateSalary() > o2.calculateSalary() ? 1 : -1); //сокращение для if / else
    }
}

// класс для сортировки работников по фамилии:
class SurNameComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.surName.compareTo(o2.surName);
    }
}



abstract class Employee implements Comparable<Employee>{ // имплементирование интерфейса Comparable

    protected String firstName;
    protected String surName;
    protected String empType;
    protected int birthYear;
    protected double salary;
    protected String comment;
    //добавить еще поля - дз done
    public Employee(String firstName, String surName, String empType, int birthYear, double salary, String comment) {
        this.firstName = firstName;
        this.surName = surName;
        this.empType = empType;
        this.birthYear = birthYear;
        this.salary = salary;
        this.comment = comment;
    }

    public abstract double calculateSalary();


    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; Год рождения: %s; Ставка: %.2f; Средняя месячная зарплата: %.2f; Комментарий: %s",
                surName, firstName, birthYear, salary, calculateSalary(), comment);
    }
}


class Worker extends Employee{

//    public Worker(String firstName, String surName, double salary) {
//        super(firstName, surName, salary);
//    }

    public Worker(String firstName, String surName, String empType, int birthYear, double salary, String comment) {
        super(firstName, surName, empType, birthYear, salary, comment);
    }

    @Override
    public double calculateSalary() {
        int salaryRate = Sample2.random.nextInt(900, 1500);
        int salaryIndex = Sample2.random.nextInt(28, 31);
        return salary = salaryRate * salaryIndex;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; Год рождения: %s; Средняя месячная зарплата: %.2f; Комментарий: %s",
                surName, firstName, birthYear, calculateSalary(), comment);
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(this.calculateSalary(), o.calculateSalary());
    }
}

//дз1 - разработать класс
class Freelancer extends Employee{
    public Freelancer(String firstName, String surName, String empType, int birthYear, double salary, String comment) {
        super(firstName, surName, empType, birthYear, salary, comment);
    }

    @Override
    public double calculateSalary() {

        int rate = Sample2.random.nextInt(200, 500);
        int hoursWorking = Sample2.random.nextInt(3, 8);
        int daysWorking = Sample2.random.nextInt(3, 20);
        return salary = rate * hoursWorking * daysWorking;
    }

    @Override
    public int compareTo(Employee o) {
        return 0;
    }

    //расчет зп
    //сколько часов, дней работал в месяц. salary*18*5

    // дз3 - создать компаратор еще один со своим методом и отсортировать по нему (добавить др и проч)
}