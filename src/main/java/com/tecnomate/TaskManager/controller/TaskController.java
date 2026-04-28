package com.tecnomate.TaskManager.controller;

import com.tecnomate.TaskManager.model.Task;
import com.tecnomate.TaskManager.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService)
    {
        this.taskService = taskService;
    }

    // POST - Create a task
    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task)
    {
        Task created = taskService.createTask(task);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // GET - Get all tasks
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks()
    {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}