package com.tecnomate.TaskManager.service;

import com.tecnomate.TaskManager.model.Task;
import com.tecnomate.TaskManager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService
{
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository)
    {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task)
    {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks()
    {
        return taskRepository.findAll();
    }
}