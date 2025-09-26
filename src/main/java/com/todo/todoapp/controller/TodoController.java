package com.todo.todoapp.controller;

import com.todo.todoapp.dto.TodoPatchDto;
import com.todo.todoapp.model.Todo;
import com.todo.todoapp.repository.TodoRepository;
import com.todo.todoapp.service.TodoService;
import org.hibernate.jdbc.Expectation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    private final TodoRepository todoRepository;
    private final TodoService todoService;

    public TodoController(TodoRepository todoRepository, TodoService todoService){
        this.todoRepository = todoRepository;
        this.todoService = todoService;
    }


    @GetMapping("/todos")
    public Iterable<Todo> findAllTodos(){
        return this.todoRepository.findAll();
    }

    @PostMapping("/todos")
    public Todo addOneTodo(@RequestBody Todo todo){
        return this.todoRepository.save(todo);
    }

    @PutMapping("/todos")
    public Todo updateOneTodo(@RequestBody Todo todo){
        return this.todoRepository.save(todo);
    }

    @PatchMapping("/todos/{id}")
    public ResponseEntity<Todo> patchTodo(
            @PathVariable Integer id,
            @RequestBody TodoPatchDto dto) {
        Todo updated = todoService.patchTodo(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/todos")
    public void deleteOneTodo(@RequestBody Todo todo){
        this.todoRepository.deleteById(todo.getId());
    }

}


