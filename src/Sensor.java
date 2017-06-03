/**
 * Created by yizhou on 6/2/17.
 */
public class Sensor {
    private int id;
    private boolean enabled;
    private double price;
    private SensorType sensorType;
    private Location location;

    public int getId() {
        return id;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public double getPrice() {
        return price;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setId(int id) {
        this.id = id;
    }


}
