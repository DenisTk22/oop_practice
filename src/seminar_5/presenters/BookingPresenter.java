package seminar_5.presenters;

import seminar_5.models.Table;
import seminar_5.models.TableModel;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver{
    private Collection<Table> tables; // ���������� tables
    private final Model model; // ������ �� model
    private final View view; // ������ �� view
    public BookingPresenter(Model model, View view){ // BookingPresenter ������� �� ������ Model � ������������� View ����� ����������
        this.model = model;
        this.view = view;
        this.view.setObserver(this); // this ��������� �� ������� ��������� �������
    }

    /**
     * ����� ��������� ������ ���� ��������
     */
    public void loadTables(){
        tables = model.loadTables(); // ��������� � ������ �� ������� loadTables
    }

    /**
     * ���������� ������ ���� ��������
     */
    public void updateView(){
        view.showTables(tables); // ��������� � ������������� (view) �� ������� showTables()
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

    // �������� ����� changeReservationTable, ������ � ������ ������
}
