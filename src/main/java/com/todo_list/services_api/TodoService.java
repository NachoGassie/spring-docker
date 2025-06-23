package com.todo_list.services_api;

import com.todo_list.DTO.TodoDTO;

import java.util.List;

public interface TodoService {
    List<TodoDTO> getAllTodos();
    TodoDTO getById(final Long id);
    TodoDTO createTodo(final TodoDTO dto);
    TodoDTO updateTodo(final Long id, final TodoDTO dto);
    void deleteTodo(final Long id);
}
