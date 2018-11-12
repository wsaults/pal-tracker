package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeEntryRepository {
    TimeEntry find(Long id);

    TimeEntry create(TimeEntry id);

    List<TimeEntry> list();

    TimeEntry update(Long id, TimeEntry timeEntry);

    void delete(Long id);
}