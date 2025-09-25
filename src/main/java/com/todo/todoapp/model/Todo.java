package com.todo.todoapp.model;


import com.todo.todoapp.model.enums.Priority;
import jakarta.persistence.*;
import org.springframework.context.annotation.Import;

@Entity
@Table(name="todos")

public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String description;

    private Priority priority;

    private Boolean isDone;

    public Todo(){}

    public Todo(String title, String description, Priority priority, Boolean isDone) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.isDone = isDone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
