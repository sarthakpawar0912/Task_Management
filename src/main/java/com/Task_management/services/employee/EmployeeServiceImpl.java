package com.Task_management.services.employee;


import com.Task_management.Entity.Task;
import com.Task_management.Entity.User;
import com.Task_management.dto.TaskDTO;
import com.Task_management.enums.TaskStatus;
import com.Task_management.repository.TaskRepository;
import com.Task_management.utils.JwtUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements  EmployeeService {

    private final TaskRepository taskRepository;
    private final JwtUtil jwtUtil;

    public EmployeeServiceImpl(TaskRepository taskRepository, JwtUtil jwtUtil) {
        this.taskRepository = taskRepository;
        this.jwtUtil = jwtUtil;
    }


    @Override
    public List<TaskDTO> getTasksByUserId() {
        User user = jwtUtil.getLoggedInUser();
        if (user != null) {
            return taskRepository.findAllByUserId(user.getId())
                    .stream()
                    .sorted(Comparator.comparing(Task::getDueDate).reversed())
                    .map(Task::getTaskDTO)
                    .collect(Collectors.toList());
        }
        throw new EntityNotFoundException("User not found");
    }

    @Override
    public TaskDTO updateTask(Long id, String status) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTaskStatus(mapStringToTaskStatus(status));
            return taskRepository.save(task).getTaskDTO();
        }
        throw new EntityNotFoundException("Task not found");
    }
    private TaskStatus mapStringToTaskStatus(String status) {
        return switch (status) {
            case "PENDING" -> TaskStatus.PENDING;
            case "INPROGRESS" -> TaskStatus.INPROGRESS;
            case "COMPLETED" -> TaskStatus.COMPLETED;
            case "DEFERRED" -> TaskStatus.DEFERRED;
            default -> TaskStatus.CANCELLED;
        };
    }

}