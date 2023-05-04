package seminar_5.models;

import com.sun.source.util.SourcePositions;
import seminar_5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


public class TableModel implements Model { // ������ ��� ����������� �� ��������

    private Collection<Table> tables; // ��������� ��������
    //private Collection<Reservation> reservations;
    /**
     * ��������� ������ ���� ��������
     * @return �������
     */
    public Collection<Table> loadTables(){
        if (tables == null){
            tables = new ArrayList<>(); // ���������� tables ��������� �� ������ ��������

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables; // ���������� ��������� ��������
    }

    /**
     * ������������ �������
     * @param reservationDate ���� ������������
     * @param tableNo ����� �������
     * @param name ��� �������
     * @return ����� �����
     */
    public int reservationTable(Date reservationDate, int tableNo, String name){
        for (Table table: tables) {
            if(table.getNo() == tableNo){
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        //throw new RuntimeException("������������ ����� �������."); // ����������
        return -1;
    }
    //����������� � ������ ��:, ��������������� ������� reservationTable
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        System.out.printf("������ ����� #",oldReservation);
        for (Table table: tables) {
            for (Reservation reservation : table.getReservations()) {
                //System.out.println(reservation.getId());
                if (reservation.getId() == oldReservation) {
                    table.getReservations().remove(reservation.getId()); // table.getReservations().remove(reservation);
                }
                System.out.println(reservation.getId());
            }
        }
        return reservationTable(reservationDate, tableNo, name);
    }
}
