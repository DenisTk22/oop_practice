package seminar_6.srp2;

public class Program {

    /**
     * TODO: �������� ������ (��������� 1),
     * �������������� ���������� � ������������ � SOLID - SRP 1� �������
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Your order:");
        Order order = new Order("", "", 0, 0);
        order.inputFromConsole();
        SaverToJson saverToJson = new SaverToJson(order);
        saverToJson.saveToJson();
    }
}
