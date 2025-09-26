package com.todo.todoapp.mapper;

import com.todo.todoapp.dto.TodoPatchDto;
import com.todo.todoapp.model.Todo;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTodoFromDto(TodoPatchDto dto, @MappingTarget Todo entity);
}
