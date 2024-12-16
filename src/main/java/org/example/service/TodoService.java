package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.TodoEntity;
import org.example.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService { // 구현해야 할 구체적인 기능들을 포함
    private final TodoRepository todoRepository;

    //1. 리스트 목록에 아이템 추가
    public TodoEntity add(TodoRequest request){
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setCompleted(request.getCompleted());
        todoEntity.setTitle(request.getTitle());
        todoEntity.setOrder(request.getOrder());
        return this.todoRepository.save(todoEntity);
    }

    //2.리스트 목록 중 특정 아이템을 조회
    public TodoEntity searchById(Long id){
        return this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    //3. 리스트 전체 목록을 조회
    public List<TodoEntity> searchAll(){
        return this.todoRepository.findAll();
    }

    //4. 리스트 목록 중 특정 아이템을 수정
    public TodoEntity updateById(Long id, TodoRequest request){
        TodoEntity todoEntity = this.searchById(id);
        if(request.getTitle() != null){
            todoEntity.setTitle(request.getTitle());
        }
        if(request.getOrder() != null){
            todoEntity.setOrder(request.getOrder());
        }
        if (request.getCompleted() != null){
            todoEntity.setCompleted(request.getCompleted());
        }
        return this.todoRepository.save(todoEntity);
    }

    //5. 리스트 목록 중 특정 아이템을 삭제
    public void deleteById(Long id){
        this.todoRepository.deleteById(id);
    }

    //6. 리스트 전체 삭제
    public void deleteAll(){
        this.todoRepository.deleteAll();
    }

}
