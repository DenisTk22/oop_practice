package seminar_5.models;

import java.util.Date;

public class Reservation {

    private static int counter = 1000; //����� ��� ����� ���������� � 1000
    private Date date; // ���� ��� ������������
    private String name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    private final int id;

    // ������������� ��� ��������
    {
        id = ++counter;
    }
    // �����������
    public Reservation(Date date, String name) {
        this.date = date;
        this.name = name;
    }
}