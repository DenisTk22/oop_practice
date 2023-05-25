package seminar_7.adapter;

public class ST500info implements SensorTemperature {

    private int id;

    public ST500info(int id) {
        this.id = id;
    }

    @Override
    public int identifier() {
        return id;
    }

    @Override
    public double temperature() {
        return -33;
    }
}
