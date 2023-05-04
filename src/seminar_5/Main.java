package seminar_5;

import seminar_5.models.TableModel;
import seminar_5.presenters.BookingPresenter;
import seminar_5.views.BookingView;

import java.util.Date;

//������������ ������� � ���������
public class Main {

    /**
     *��������� ����� changeReservationTable
     * @param args
     */
    public static void main(String[] args) {

        TableModel model = new TableModel(); // �������� ������
        BookingView view = new BookingView(); // �������� �������������
        BookingPresenter bookingPresenter = new BookingPresenter(model, view); // �������� ����������

        bookingPresenter.loadTables(); // ��������� � ���������� ��������� ��� �������
        bookingPresenter.updateView(); // ������������ ��������

        // ������������ �������
        view.reservationTable(new Date(), 1, "�����");
        view.reservationTable(new Date(), 2, "������");
//        view.reservationTable(new Date(), 1, "�����");
//        view.reservationTable(new Date(), 3, "�����");
        // ��������� ������������ �������
                view.changeReservationTable(1001, new Date(), 3, "�����"); // 3 - ����� ����� �������
    }
}