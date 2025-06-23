package com.todo_list.services.mapper;

import com.todo_list.DTO.TodoDTO;
import com.todo_list.models.Todo;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {
    public TodoDTO entityToDto(final Todo entity){
        final TodoDTO dto = new TodoDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public Todo dtoToEntity(final TodoDTO dto){
        final Todo entity = new Todo();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
