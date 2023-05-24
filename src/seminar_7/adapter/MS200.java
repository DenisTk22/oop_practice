package seminar_7.adapter;

public class MS200 implements MeteoSenser{

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getTemperature() {
        return 20;
    }

    @Override
    public double getHumidity() {
        return 0;
    }

    @Override
    public double getPressure() {
        return 0;
    }
}
