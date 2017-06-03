package Model;
import java.util.*;

/**
 * Created by Administrator on 2017/6/2.
 */
public class Schedule {

    private Service service;

    private Long id;

    public Date getFromDay() {
        return fromDay;
    }

    public void setFromDay(Date fromDay) {
        this.fromDay = fromDay;
    }

    public Date getToDay() {
        return toDay;
    }

    public void setToDay(Date toDay) {
        this.toDay = toDay;
    }

    private Date fromDay;
    private Date toDay;
    private Time fromTime;
    private Time toTime;

    public Schedule() {
    }

    public Schedule(
            final Service service) {
        this.service = service;
    }

    public Schedule(
            final Service service,  final Time fromTime, final Time toTime) {
        this.service = service;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Service getService() {
        return service;
    }

    public void setService(final Service service) {
        this.service = service;
    }
    public Time getFromTime() {
        return  fromTime;
    }

    public void setFromTime(final Time fromTime) {
        this.fromTime = fromTime;
    }

    public Time getToTime() {
        return toTime;
    }

    public void setToTime(final Time toTime) {
        this.toTime = toTime;
    }

    public boolean contains(Date dayNew) {
        if (dayNew != null) {

            if ((dayNew.compareTo(fromDay) >= 0) && (dayNew.compareTo(toDay) <= 0)) return true;

        }
        return false;
    }
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Id = " + id);
        sb.append("service = " + service);
        sb.append("fromDay = " + fromDay);
        sb.append("toDay = " + toDay);
        sb.append("fromTime = " + fromTime);
        sb.append("toTime = " + toTime);
        return sb.toString();
    }

}























}
