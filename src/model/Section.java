package model;

import model.Sensor.SensorType;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Section {

    public enum SensorState {
        UNINSTALLED,
        ACTIVATED,
        DEACTIVATED,
        SCHEDULED
    }

    private final String id;
    private final String name;
    private final Map<SensorType, SensorState> sensorStateMap = new HashMap<>();
    private final Map<SensorType, ScheduledTimeRange> scheduledTimeRangeMap = new HashMap<>();

    public Section(String sectionString) {
        String[] sectionStateArray = sectionString.split(",");
        id = sectionStateArray[0];
        name = sectionStateArray[1];
        sensorStateMap.put(SensorType.MOTION, SensorState.valueOf(sectionStateArray[2]));
        sensorStateMap.put(SensorType.TEMPERATURE, SensorState.valueOf(sectionStateArray[3]));

        scheduledTimeRangeMap.put(SensorType.MOTION,
                new ScheduledTimeRange(Integer.valueOf(sectionStateArray[4]), Integer.valueOf(sectionStateArray[5])));
        scheduledTimeRangeMap.put(SensorType.TEMPERATURE,
                new ScheduledTimeRange(Integer.valueOf(sectionStateArray[6]), Integer.valueOf(sectionStateArray[7])));
    }

    public SensorState getSensorState(SensorType sensorType) {
        return sensorStateMap.get(sensorType);
    }

    public void setSensorState(SensorType sensorType, SensorState sensorState) {
        sensorStateMap.put(sensorType, sensorState);
    }

    public LocalTime getSensorScheduledFromTime(SensorType sensorType) {
        return scheduledTimeRangeMap.get(sensorType).getFrom();
    }

    public void setSensorScheduledFromTime(SensorType sensorType, LocalTime sensorScheduledFromTime) {
        scheduledTimeRangeMap.get(sensorType).setFrom(sensorScheduledFromTime);
    }

    public LocalTime getSensorScheduledToTime(SensorType sensorType) {
        return scheduledTimeRangeMap.get(sensorType).getTo();
    }

    public void setSensorScheduledToTime(SensorType sensorType, LocalTime sensorScheduledToTime) {
        scheduledTimeRangeMap.get(sensorType).setTo(sensorScheduledToTime);
    }

    public boolean isSensorInstalled(SensorType sensorType) {
        return !sensorStateMap.get(sensorType).equals(SensorState.UNINSTALLED);
    }

    public void setSensorInstalled(SensorType sensorType, boolean installed) {
        sensorStateMap.put(sensorType, installed ? SensorState.ACTIVATED : SensorState.UNINSTALLED);
    }

    public boolean isSensorActive(SensorType sensorType) {
        switch (sensorStateMap.get(sensorType)) {
            case ACTIVATED:
                return true;
            case SCHEDULED:
                return scheduledTimeRangeMap.get(sensorType).isInRange(LocalTime.now());
            default:
                return false;
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",
                id,
                name,
                sensorStateMap.get(SensorType.MOTION),
                sensorStateMap.get(SensorType.TEMPERATURE),
                scheduledTimeRangeMap.get(SensorType.MOTION).toString(),
                scheduledTimeRangeMap.get(SensorType.TEMPERATURE).toString());
    }
}
