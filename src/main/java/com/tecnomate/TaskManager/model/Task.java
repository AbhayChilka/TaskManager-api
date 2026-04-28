package com.tecnomate.TaskManager.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Task
{
    private Long id;
    private String title;
    private String description;

    private Status status = Status.PENDING;

    private Priority priority;
    private String priorityReason;
}
