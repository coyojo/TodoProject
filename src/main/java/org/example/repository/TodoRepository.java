package org.example.repository;

import org.example.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {  //Db에 todoEntity만 저장되게 설계했으니 Repository는 TodoEntity만을 위한것만 만들면 된다

}
