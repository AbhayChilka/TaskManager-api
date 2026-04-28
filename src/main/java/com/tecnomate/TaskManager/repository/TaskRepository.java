package com.tecnomate.TaskManager.repository;

import com.tecnomate.TaskManager.model.Task;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TaskRepository
{
    private final Map<Long, Task> store = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    //new
    public Task save(Task task)
    {
        if (task.getId() == null)
        {
            Long id = idCounter.getAndIncrement();
            task.setId(id);
        }
        store.put(task.getId(), task);
        return task;
    }

    //show
    public List<Task> findAll()
    {
        return new ArrayList<>(store.values());
    }

    //update status
    public Optional<Task> findById(Long id)
    {
        return Optional.ofNullable(store.get(id));
    }
}