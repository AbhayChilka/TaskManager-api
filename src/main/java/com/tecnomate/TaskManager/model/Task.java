package com.tecnomate.TaskManager.model;

import lombok.Data;

@Data
public class Task
{
    private Long id;
    private String title;
    private String description;

    public Task(Long id, String title, String description)
    {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
