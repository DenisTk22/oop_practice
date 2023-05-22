package seminar_5.models;

import java.util.Date;

public class Reservation {

    private static int counter = 1000; //номер для брони начинается с 1000
    private Date date; // дата для бронирования
    private String name;
    private final int id;

    public String getName() { // создали геттер для доступа к переменной с областью видимости private
        return name;
    }
    public int getId() {
        return id;
    }
    public Date getDate() {
        return date;
    }

    // инициализатор для счетчика
    {
        id = ++counter;
    }

    // конструктор
    public Reservation(Date date, String name) {
        this.date = date;
        this.name = name;
    }
}