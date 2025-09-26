package com.todo.todoapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.todo.todoapp.model.enums.Priority;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TodoPatchDto {
    private String title;
    private Priority priority;
    private Boolean isDone;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
