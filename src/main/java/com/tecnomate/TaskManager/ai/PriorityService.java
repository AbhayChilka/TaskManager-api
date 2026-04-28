package com.tecnomate.TaskManager.ai;

import com.tecnomate.TaskManager.model.Priority;
import org.springframework.stereotype.Service;

@Service
public class PriorityService
{
    public Result suggest(String title, String description) {

        String text = (title + " " +
                (description == null ? "" : description)).toLowerCase();

        if (text.contains("urgent") || text.contains("critical") || text.contains("asap")) {
            return new Result(Priority.HIGH, "Detected urgency keywords");
        }

        if (text.contains("later") || text.contains("optional")) {
            return new Result(Priority.LOW, "Detected low priority intent");
        }

        return new Result(Priority.MEDIUM, "Default priority assigned");
    }

    public static class Result {
        public Priority priority;
        public String reason;

        public Result(Priority priority, String reason) {
            this.priority = priority;
            this.reason = reason;
        }
    }
}
