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

    public Task save(Task task)
    {
        Long id = idCounter.getAndIncrement();
        task.setId(id);
        store.put(id, task);
        return task;
    }

    public List<Task> findAll()
    {
        return new ArrayList<>(store.values());
    }
}