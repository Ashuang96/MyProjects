package com.hand.bean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;


@Setter
@Getter
@ToString
public class ItemBean {

    private Long id;

    @NotNull(message = "用户id不能为空")
    private Long userId;

    @NotBlank(message = "事项名不能为空")
    private String todoItemTitle;


    private String todoItemContent;

    @NotBlank(message = "优先级不能为空")
    private String priority;

    private String comments;

    public ItemBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTodoItemTitle() {
        return todoItemTitle;
    }

    public void setTodoItemTitle(String todoItemTitle) {
        this.todoItemTitle = todoItemTitle;
    }

    public String getTodoItemContent() {
        return todoItemContent;
    }

    public void setTodoItemContent(String todoItemContent) {
        this.todoItemContent = todoItemContent;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
