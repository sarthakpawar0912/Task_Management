package com.Task_management.services.employee;

import com.Task_management.Entity.Task;
import com.Task_management.dto.TaskDTO;

import java.util.List;

public interface EmployeeService {

    List<TaskDTO> getTasksByUserId();

    TaskDTO  updateTask(Long id, String status);
}
