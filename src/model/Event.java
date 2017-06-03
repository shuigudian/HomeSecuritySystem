package model;

import java.util.Date;

/**
 * Created by yizhou on 6/2/17.
 */
public class Event {
    private int id;
    // 0 denote break, 1 denote fire, 2 denote both
    private int eventType;
    private Location location;
    private Date occurenceTime;
    private Date firstCallMade;
    private Date responseTime;
    private boolean alarmed;
    private boolean callMade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public Date getOccurenceTime() {
        return occurenceTime;
    }

    public void setOccurenceTime(Date occurenceTime) {
        this.occurenceTime = occurenceTime;
    }

    public Date getFirstCallMade() {
        return firstCallMade;
    }

    public void setFirstCallMade(Date firstCallMade) {
        this.firstCallMade = firstCallMade;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public boolean isAlarmed() {
        return alarmed;
    }

    public void setAlarmed(boolean alarmed) {
        this.alarmed = alarmed;
    }

    public boolean isCallMade() {
        return callMade;
    }

    public void setCallMade(boolean callMade) {
        this.callMade = callMade;
    }
}
