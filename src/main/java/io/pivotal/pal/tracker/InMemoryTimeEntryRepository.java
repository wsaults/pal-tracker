package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private List<TimeEntry> inMemoryList;

    public InMemoryTimeEntryRepository() {
        inMemoryList = new ArrayList<>();
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        for (TimeEntry t : inMemoryList) {
            if (t.getId() == timeEntryId) {
                return t;
            }
        }

        return null;
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry t = new TimeEntry(
                inMemoryList.size()+1,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours());

        inMemoryList.add(t);

        return t;
    }

    @Override
    public List<TimeEntry> list() {
        return inMemoryList;
    }

    @Override
    public TimeEntry update(long timeEntryId, TimeEntry timeEntry) {
        TimeEntry currentT = find(timeEntryId);
        TimeEntry newT = new TimeEntry(
                timeEntryId,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours());
        inMemoryList.remove(currentT);
        inMemoryList.add(newT);
        return newT;
    }

    @Override
    public void delete(long timeEntryId) {
        TimeEntry timeEntry = find(timeEntryId);
        if (timeEntry != null) {
            inMemoryList.remove(timeEntry);
        }
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
