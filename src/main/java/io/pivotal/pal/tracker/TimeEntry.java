package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {
    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry() {

    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this.id = 1L;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public long getId() {
        return this.id;
    }

    public long getProjectId() {
        return this.projectId;
    }

    public long getUserId() {
        return this.userId;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public int getHours() {
        return this.hours;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof TimeEntry))return false;

        TimeEntry timeEntry = (TimeEntry)obj;

        boolean isIdEqual = timeEntry.getId() == this.getId();
        boolean isProjectIdEqual = timeEntry.getProjectId() == this.getProjectId();
        boolean isUserIdEqual = timeEntry.getUserId() == this.getUserId();
        boolean isDateEqual = timeEntry.getDate().equals(this.getDate());
        boolean isHoursEqual = timeEntry.getHours() == this.getHours();

        return isIdEqual && isProjectIdEqual && isUserIdEqual && isDateEqual && isHoursEqual;
    }
}
