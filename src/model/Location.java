package model;

import model.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/2.
 */
public class Location {
    private Long id;

    private String locationCode;
    private String locationName;
    private Service service;
    private List<Sensor> sensors = new ArrayList<Sensor>();
    private List<Event> events = new ArrayList<Event>();

    public Location() {
    }

    public Location(final String locationCode, final String locationName, final Service service) {
        this.locationCode = locationCode;
        this.locationName = locationName;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(final String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(final String locationName) {
        this.locationName = locationName;
    }

    public void setService(final Service service) {
        this.service = service;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(final List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public void addSensor(final Sensor sensor) {
        sensors.add(sensor);
    }

    public void addEvent(final Event event) {
        events.add(event);
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(final List<Event> events) {
        this.events = events;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Id = " + id);
        sb.append("locationName = " + locationName);
        sb.append("serviceCode = " + service.getServiceCode());
        return sb.toString();
    }
}