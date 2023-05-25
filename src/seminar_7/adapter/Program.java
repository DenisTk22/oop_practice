package seminar_7.adapter;

public class Program {
    public static void main(String[] args) {


        ST500info st500info_1 = new ST500info(4561);

        MS200 ms200_1 = new MS200(12565);

        MeteoStore meteoStore = new MeteoStore();

        meteoStore.save(ms200_1);
        meteoStore.save(new AdapterST500Info(st500info_1));

    }
}
