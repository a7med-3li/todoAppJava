package com.todo.todoapp.service;

import com.todo.todoapp.dto.TodoPatchDto;
import com.todo.todoapp.mapper.TodoMapper;
import com.todo.todoapp.model.Todo;
import com.todo.todoapp.repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public TodoService(TodoRepository todoRepository, TodoMapper todoMapper) {
        this.todoRepository = todoRepository;
        this.todoMapper = todoMapper;
    }

    @Transactional
    public Todo patchTodo(Integer id, TodoPatchDto dto) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        todoMapper.updateTodoFromDto(dto, todo);
        return todoRepository.save(todo);
    }
}
