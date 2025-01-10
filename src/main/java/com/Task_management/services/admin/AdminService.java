package com.Task_management.services.admin;

import com.Task_management.dto.CommentDTO;
import com.Task_management.dto.TaskDTO;
import com.Task_management.dto.UserDto;

import java.util.List;

public interface AdminService {

    List<UserDto> getUsers();

   TaskDTO createTask(TaskDTO taskDTO);

   List<TaskDTO>getAllTasks();

   void deleteTask(Long id);

   TaskDTO getTaskById(Long id);

    TaskDTO updateTask(Long id,TaskDTO taskDTO);

    List<TaskDTO>  SearchTaskByTitle(String title);


    CommentDTO createComment(Long taskId,String content);


     List<CommentDTO> getCommentsByTaskId(Long taskId);

}
