package com.tecnomate.TaskManager.service;

import com.tecnomate.TaskManager.ai.PriorityService;
import com.tecnomate.TaskManager.model.Status;
import com.tecnomate.TaskManager.model.Task;
import com.tecnomate.TaskManager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService
{
    private final TaskRepository taskRepository;
    private final PriorityService priorityService;

    public TaskService(TaskRepository taskRepository, PriorityService priorityService)
    {
        this.taskRepository = taskRepository;
        this.priorityService = priorityService;
    }

    //create new task
    public Task createTask(Task task)
    {
        if (task.getTitle() == null || task.getTitle().isBlank())
        {
            throw new RuntimeException("Title is required");
        }

        var result = priorityService.suggest(task.getTitle(), task.getDescription());

        task.setPriority(result.priority);
        task.setPriorityReason(result.reason);

        task.setStatus(Status.PENDING);

        return taskRepository.save(task);
    }

    //show list of all tasks
    public List<Task> getAllTasks()
    {
        return taskRepository.findAll();
    }

    // update status of pending task
    public Task markComplete(Long id)
    {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(Status.COMPLETED);
        return taskRepository.save(task);
    }


}