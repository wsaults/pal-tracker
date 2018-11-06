package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeEntryRepository extends Repository {
    TimeEntry find(long timeEntryId);

    TimeEntry create(TimeEntry timeEntry);

    List<TimeEntry> list();

    TimeEntry update(long timeEntryId, TimeEntry timeEntry);

    void delete(long timeEntryId);
}
