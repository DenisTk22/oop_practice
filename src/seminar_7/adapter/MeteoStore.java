package seminar_7.adapter;

public class MeteoStore {

    boolean save(MeteoSensor meteoSensor){
        System.out.printf("���������� ������ �� ������������\n [%d]; temperature - %f\n",
                meteoSensor.getId(), meteoSensor.getTemperature());
        return true;
    }



}
