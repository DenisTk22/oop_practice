package seminar_7.adapter;

public interface MeteoSenser {

    int getId(); //идентификатор сенсора датчика

    double getTemperature();
    double getHumidity();
    double getPressure();

}
