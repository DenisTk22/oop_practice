package practice_4.task1;

import java.util.Arrays;

//���������
public class Sample01 {

    public static void main(String[] args) {

        SimpleAccount simpleAccount1 = new SimpleAccount(3001,10500);

        int simpleAccount1Id = simpleAccount1.getId();
        System.out.println(simpleAccount1);

        UniversalAccount universalAccount1 = new UniversalAccount(15, 1050);
        System.out.println(universalAccount1);

        UniversalAccount universalAccount2 = new UniversalAccount(20, 1100.23);
        System.out.println(universalAccount2);

        UniversalAccount universalAccount3 =
                new UniversalAccount(new CustomAccountIdetificator(11, "513"), 1542);
        System.out.println(universalAccount3);
        //CustomAccountIdetificator customId = (CustomAccountIdetificator)universalAccount2.getId();

        Account<CustomAccountIdetificator> account1 =
                new Account<CustomAccountIdetificator>(new CustomAccountIdetificator(11, "513"), 1542);

        CustomAccountIdetificator accountId1 = account1.getId();

        Account<String> account2 =
                new Account<>("ad", 1542);

        Account<Integer> account3 =
                new Account<>(4, 1542);

        Integer[] array1 = {1, 2, 3, 58, -9};
        String[] array2 = {"sd", "sdg", "ew"};


        Integer[] newArray = (Integer[]) ArrayUtils.replaceTwoElements(array1, 1, 2); //downcasting

        ArrayUtils.<String>replaceTwoElementsV2(array2, 1, 2); // ��� ��������� �� �����������, �.�. array2 - ��� String
        //ArrayUtils.<Integer>Sample(); // ����� ������� ��� �������������� ���������

        String[] newArray2 = ArrayUtils.replaceTwoElementsV2(array2, 1, 2);
        System.out.println(Arrays.toString(newArray2));
    }
}

class ArrayUtils{
    public static Object[] replaceTwoElements(Object[] array, int index1, int index2){
        Object[] newArray = array.clone();
        if (index1 >= newArray.length || index2 >= newArray.length || index1 < 0 || index2 < 0)
            return null;
        Object obj = newArray[index1];
        newArray[index1] = newArray[index2];
        newArray[index2] = obj;
        return newArray;
    }

    //��������� ������� ������ (������������� �������������� ���������, ������ ������ <T>)

//    public static <T> T Sample(){
//        return null;
//    }
    public static<T> T[] replaceTwoElementsV2(T[] array, int index1, int index2){
        T[] newArray = array.clone();
        if (index1 >= newArray.length || index2 >= newArray.length || index1 < 0 || index2 < 0)
            return null;
        T obj = newArray[index1];
        newArray[index1] = newArray[index2];
        newArray[index2] = obj;
        return newArray;
    }

}

class Account<T>{  //������������� �������� - ����� ��������
    private final T id; //final - �� �������� ���������
    private double amount;

    public double getAmount() {
        return amount;
    }

    public T getId() {
        return id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account(T id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("����� ������� �� �����%s, %s", id, amount);
    }
}
class UniversalAccount{
    private final Object id; //final - �� �������� ���������
    private double amount;

    public double getAmount() {
        return amount;
    }

    public Object getId() {
        return id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public UniversalAccount(Object id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("����� ������� �� �����%s", amount);
    }
}

class CustomAccountIdetificator{
    private int id;
    private String prefix;

    public int getId() {
        return id;
    }

    public String getPrefix() {
        return prefix;
    }

    public CustomAccountIdetificator(int id, String prefix) {
        this.id = id;
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return "CustomAccountIdetificator{" +
                "id=" + id +
                ", prefix='" + prefix + '\'' +
                '}';
    }
}

class SimpleAccount{
    private final int id; //final - �� �������� ���������
    private double amount;

    public double getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public SimpleAccount(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("����� ������� �� �����%s", amount);
    }
}