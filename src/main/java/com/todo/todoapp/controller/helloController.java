package com.todo.todoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @GetMapping("/")
    public String home() {
        return "Hello, TodoApp is running!";
    }
}
