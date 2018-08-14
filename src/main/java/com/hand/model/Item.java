package com.hand.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {
    private Long todoItemId;

    private Long userId;

    @NotBlank(message = "事项名不能为空")
    private String todoItemTitle;

    @NotBlank(message = "内容不能为空")
    private String todoItemContent;

    @NotBlank(message = "优先级不能为空")
    private String priority;

    private Date creationDate;

    private Date lastUpdateDate;

    private String comments;

    public Long getTodoItemId() {
        return todoItemId;
    }

    public void setTodoItemId(Long todoItemId) {
        this.todoItemId = todoItemId;
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
        this.todoItemTitle = todoItemTitle == null ? null : todoItemTitle.trim();
    }

    public String getTodoItemContent() {
        return todoItemContent;
    }

    public void setTodoItemContent(String todoItemContent) {
        this.todoItemContent = todoItemContent == null ? null : todoItemContent.trim();
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }
}