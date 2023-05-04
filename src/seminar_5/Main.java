package seminar_5;

import seminar_5.models.TableModel;
import seminar_5.presenters.BookingPresenter;
import seminar_5.views.BookingView;

import java.util.Date;

//бронирование столика в ресторане
public class Main {

    /**
     *«апустить метод changeReservationTable
     * @param args
     */
    public static void main(String[] args) {

        TableModel model = new TableModel(); // создание модели
        BookingView view = new BookingView(); // создание представлени€
        BookingPresenter bookingPresenter = new BookingPresenter(model, view); // создание презентора

        bookingPresenter.loadTables(); // обращение к презентору загрузить все столики
        bookingPresenter.updateView(); // визуализаци€ столиков

        // бронирование столика
        view.reservationTable(new Date(), 1, "ƒенис");
        view.reservationTable(new Date(), 2, "јндрей");
//        view.reservationTable(new Date(), 1, "ƒенис");
//        view.reservationTable(new Date(), 3, "ƒенис");
        // изменение бронировани€ столика
                view.changeReservationTable(1001, new Date(), 3, "ƒенис"); // 3 - новый номер столика
    }
}