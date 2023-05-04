package seminar_5.views;

import seminar_5.models.Table;
import seminar_5.presenters.View;
import seminar_5.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private ViewObserver observer; // ������ �� �����������

    /**
     * ���������� �����������, �������������� �������� ������������
     * @param observer �����������
     */
    public void setObserver(ViewObserver observer){
        this.observer = observer; // ������ �� �����������
    }

    /**
     * ���������� ������ ���� �������
     * @param tables �����
     */
    public void showTables(Collection<Table> tables){ // �������� ��������
        for (Table table: tables){
            System.out.println(table);
        }

    }

    /**
     * �������� ������� (������������ ����� �� ������ ������������),
     * ������������ �������
     * @param reservationDate ���� ������������
     * @param tableNo ����� �������
     * @param name ��� �������
     */
    public void reservationTable(Date reservationDate, int tableNo, String name){
        observer.onReservationTable(reservationDate, tableNo, name);

    }

    /**
     * TODO: ���������� ����� � ��.
     * �������� ������� (������������ ����� �� ������),
     * ��������� ����������� �������
     * @param oldReservation ������ ����� �����
     * @param reservationDate ����� ���� ������������
     * @param tableNo ����� �������
     * @param name ��� �������
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);

    }

    /**
     * ���������� ��������� �������������� �������
     * @param reservationId ����� �����
     */
    public void showReservationTableStatus(int reservationId){
        if(reservationId > 0){
            System.out.printf("������ ������� ������������.\n����� �����: #%d\n", reservationId);
        }
        else {
            System.out.println("������ ������������.\n��������� ������� �����.");
        }
    }
}
