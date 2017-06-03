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

    public Location getLocation() {
        return location;
    }

    public int getEventType() {
        return eventType;
    }

    public Date getOccurenceTime() {
        return occurenceTime;
    }

    public Date getFirstCallMade() {
        return firstCallMade;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public boolean isAlarmed() {
        return alarmed;
    }

    public boolean isCallMade() {
        return callMade;
    }
}
