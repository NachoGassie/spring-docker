package com.todo_list.services;

import com.todo_list.DTO.TodoDTO;
import com.todo_list.models.Todo;
import com.todo_list.repositories.TodoRepository;
import com.todo_list.services.mapper.TodoMapper;
import com.todo_list.services_api.TodoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    @Override
    public List<TodoDTO> getAllTodos() {
        return todoRepository.findAll().stream().map(todoMapper::entityToDto).toList();
    }

    @Override
    public TodoDTO getById(final Long id) {
        final Todo todo = todoRepository.findById(id)
            .orElseThrow(EntityNotFoundException::new);
        return todoMapper.entityToDto(todo);
    }

    private Todo getEntityById(final Long id) {
        return todoRepository.findById(id)
            .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public TodoDTO createTodo(final TodoDTO dto) {
        final Todo saved = todoRepository.save(todoMapper.dtoToEntity(dto));
        return todoMapper.entityToDto(saved);
    }

    @Override
    public TodoDTO updateTodo(Long id, TodoDTO dto) {
        final Todo entity = getEntityById(id);
        entity.setName(dto.getName());
        return todoMapper.entityToDto(todoRepository.save(entity));
    }

    @Override
    public void deleteTodo(final Long id) {
        final boolean exists = todoRepository.existsById(id);
        if (!exists) throw new EntityNotFoundException();
        todoRepository.deleteById(id);
    }

}
