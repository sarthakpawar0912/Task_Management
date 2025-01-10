package com.Task_management.dto;

import com.Task_management.Entity.Task;
import com.Task_management.enums.TaskStatus;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class TaskDTO {




    private String title;

    private String description;

    private Date dueDate;

    private  String priority;

    private TaskStatus taskStatus;

    private  Long employeeId;

    private String employeeName;

    public TaskDTO(String employeeName, Long employee, TaskStatus taskStatus, String priority, Date dueDate, String description, String title) {
        this.employeeName = employeeName;

        this.taskStatus = taskStatus;
        this.priority = priority;
        this.dueDate = dueDate;
        this.description = description;
        this.title = title;

    }

    public TaskDTO() {
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

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

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employee) {
        this.employeeId = employee;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", priority='" + priority + '\'' +
                ", taskStatus=" + taskStatus +
                ", employee=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }



}
