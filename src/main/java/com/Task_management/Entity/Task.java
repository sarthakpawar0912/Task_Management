package com.Task_management.Entity;

import com.Task_management.dto.TaskDTO;
import com.Task_management.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String title;

    private String description;

    private Date dueDate;

    private  String priority;

    private TaskStatus  taskStatus;


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private  User user;


    public Task(Long id, String title, String description, Date dueDate, String priority, TaskStatus taskStatus, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.taskStatus = taskStatus;
        this.user = user;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", prioprity='" + priority + '\'' +
                ", taskStatus=" + taskStatus +
                ", user=" + user +
                '}';
    }



    public TaskDTO getTaskDTO(){
        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setTitle(title);
        taskDTO.setDescription(description);
        taskDTO.setDueDate(dueDate);
        taskDTO.setPriority(priority);
        taskDTO.setTaskStatus(taskStatus);
        taskDTO.setEmployeeId(this.user.getId());
        taskDTO.setEmployeeName(this.user.getName());
        return taskDTO;
    }
}
