package com.todo.todoapp.controller;


import com.todo.todoapp.model.Todo;
import com.todo.todoapp.repository.TodoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    private final TodoRepository todoRepository;
    public TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }


    @GetMapping("/todos")
    public Iterable<Todo> findAllTodos(){
        return this.todoRepository.findAll();
    }

    @PostMapping("/todos")
    public Todo addOneTodo(@RequestBody Todo todo){
        return this.todoRepository.save(todo);
    }

}


