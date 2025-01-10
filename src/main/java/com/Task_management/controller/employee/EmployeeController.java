package com.Task_management.controller.employee;


import com.Task_management.dto.TaskDTO;
import com.Task_management.services.employee.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }




    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDTO>> getTaskByUserId(){
        return ResponseEntity.ok(employeeService.getTasksByUserId());
    }


    @GetMapping("/tasks/{id}/{status}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestParam String status){
        TaskDTO updateTaskDTO=employeeService.updateTask(id,status);
        if(updateTaskDTO==null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(updateTaskDTO);
    }









}
