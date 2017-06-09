package model;

import java.util.Date;
// This class is deigned to maintain Event information
public class Event {

    public enum EventType {
        BREAK_IN,
        FIRE
    }

    private final EventType eventType;
    private final String sectionId;
    private final Date triggerTime;
    private final Date firstCallTime;
    private final int callCount;
    private final Date responseTime;
// constructor of Event
    public Event(EventType eventType, String sectionId, Date triggerTime, Date firstCallTime, int callCount, Date responseTime) {
        this.eventType = eventType;
        this.sectionId = sectionId;
        this.triggerTime = triggerTime;
        this.firstCallTime = firstCallTime;
        this.callCount = callCount;
        this.responseTime = responseTime;
    }
    // constructor of Event
    public Event(String eventString) {
        String[] eventStringList = eventString.split(",");
        this.eventType = EventType.valueOf(eventStringList[0]);
        this.sectionId = eventStringList[1];
        this.triggerTime = new Date(Long.valueOf(eventStringList[2]));
        this.firstCallTime = new Date(Long.valueOf(eventStringList[3]));
        this.callCount = Integer.valueOf(eventStringList[4]);
        this.responseTime = new Date(Long.valueOf(eventStringList[5]));
    }
// get Event Type
    public EventType getEventType() {
        return eventType;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",
                eventType,
                sectionId,
                triggerTime.getTime(),
                firstCallTime.getTime(),
                callCount,
                responseTime.getTime());
    }
}
