package seminar_5.presenters;

import seminar_5.models.Table;
import seminar_5.models.TableModel;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver{
    private Collection<Table> tables; // переменна€ tables
    private final Model model; // ссылка на model
    private final View view; // ссылка на view
    public BookingPresenter(Model model, View view){ // BookingPresenter зависит от модели Model и представлени€ View через интерфейсы
        this.model = model;
        this.view = view;
        this.view.setObserver(this); // this указывает на текущей экземпл€р объекта
    }

    /**
     * ћетод получени€ списка всех столиков
     */
    public void loadTables(){
        tables = model.loadTables(); // обращение к модели за методом loadTables
    }

    /**
     * ќтобразить список всех столиков
     */
    public void updateView(){
        view.showTables(tables); // обращение к представлению (view) за методом showTables()
    }


    public void updateReservationTableStatus(int reservationId){
        view.showReservationTableStatus(reservationId);
    }
    @Override
    public void onReservationTable(Date reservationDate, int tableNo, String name) {
        int reservationId = model.reservationTable(reservationDate, tableNo, name);
        updateReservationTableStatus(reservationId);
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int reservationId = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
        updateReservationTableStatus(reservationId);
    }

    // по€витс€ метод changeReservationTable, пойдет в модель данных
}
