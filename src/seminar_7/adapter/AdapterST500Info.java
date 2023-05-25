package seminar_7.adapter;

public class AdapterST500Info implements MeteoSensor{


    private final SensorTemperature sensorTemperature;

    public AdapterST500Info(SensorTemperature sensorTemperature){
        this.sensorTemperature = sensorTemperature;
    }

    @Override
    public int getId() {
        return sensorTemperature.identifier();
    }

    @Override
    public double getTemperature() {
        return sensorTemperature.temperature();
    }

    @Override
    public double getHumidity() {
        throw new RuntimeException("Получить влажность с этого датчика нельзя");
    }

    @Override
    public double getPressure() {
        throw new RuntimeException("Получить давление с этого датчика нельзя");
    }
}
