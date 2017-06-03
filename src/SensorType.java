/**
 * Created by yizhou on 6/2/17.
 */
public enum SensorType {
    MOTION(1), TEMPERATURE(2);
    private int typeId;

    SensorType(int typeId) {
        this.typeId = typeId;
    }

    public int getSensorType() {
        return typeId;
    }
}
