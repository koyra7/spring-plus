package org.example.expert.domain.todo.repository;


import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import org.example.expert.domain.todo.dto.response.TodoResponse;
import org.example.expert.domain.todo.entity.QTodo;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.user.dto.response.UserResponse;
import org.example.expert.domain.user.entity.QUser;


import java.util.Optional;

@RequiredArgsConstructor
public class TodoRepositoryImpl implements CustomTodoRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Todo> findByIdWithUser(Long todoId) {

        QTodo todo = QTodo.todo;
        QUser user = QUser.user;

        Todo result = (Todo) jpaQueryFactory
                .select(Projections.constructor(TodoResponse.class, todo.id, todo.title, todo.contents, todo.weather.stringValue(),
                        Projections.constructor(UserResponse.class, user.id, user.email), todo.createdAt, todo.modifiedAt)
                )
                .from(todo)
                .leftJoin(user).on(user.id.eq(todo.user.id))
                .where(todo.id.eq(todoId))
                .fetch();

        return Optional.ofNullable(result);
    }


}
