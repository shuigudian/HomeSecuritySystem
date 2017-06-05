package model;

import java.time.LocalTime;

public class ScheduledTimeRange {
    private static final LocalTime DEFAULT_SCHEDULED_TIME = LocalTime.ofSecondOfDay(0);

    private LocalTime from = DEFAULT_SCHEDULED_TIME;
    private LocalTime to = DEFAULT_SCHEDULED_TIME;

    ScheduledTimeRange(int fromSec, int toSec) {
        this.from = LocalTime.ofSecondOfDay(fromSec);
        this.to = LocalTime.ofSecondOfDay(toSec);
    }


    LocalTime getFrom() {
        return from;
    }

    LocalTime getTo() {
        return to;
    }

    void setFrom(LocalTime from) {
        this.from = from;
    }

    void setTo(LocalTime to) {
        this.to = to;
    }

    boolean isInRange(LocalTime time) {
        return time.isAfter(from) && time.isBefore(to);
    }

    @Override
    public String toString() {
        return String.format("%d,%d", from.toSecondOfDay(), to.toSecondOfDay());
    }
}
