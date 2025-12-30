package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.dto.response.TodoResponse;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomTodoRepository {

    Optional<Todo> findByIdWithUser(@Param("todoId") Long todoId);
}
