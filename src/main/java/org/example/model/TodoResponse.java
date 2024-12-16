package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {
    private Long id;
    private String title;
    private Long order;
    private Boolean completed;
    private String url;



    public TodoResponse(TodoEntity todoEntity){
        this.id = id;
        this.title = title;
        this.order = order;
        this.completed = completed;
        this.url = "http://localhost:8080/" + this.id;

    }

}
