package seminar_5.presenters;

import seminar_5.models.Table;

import java.util.Collection;

public interface View {

    /**
     * ���������� ������ ���� �������
     * @param tables �������
     */
    void showTables(Collection<Table> tables); // ��������� ����� showTables()

    /**
     * ���������� �����������, �������������� �������� ������������
     * @param observer �����������
     */
    void setObserver(ViewObserver observer); // ��������� ����� setObserver()

    /**
     * ���������� ��������� �������������� ������
     * @param reservationId ����� �����
     */
    void showReservationTableStatus(int reservationId);
}
