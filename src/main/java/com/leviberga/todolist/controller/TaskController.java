package com.leviberga.todolist.controller;

import com.leviberga.todolist.dto.TaskRequestDTO;
import com.leviberga.todolist.dto.TaskResponseDTO;
import com.leviberga.todolist.model.Tasks;
import com.leviberga.todolist.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> newTask(@Valid @RequestBody TaskRequestDTO newTask){
        TaskResponseDTO task = taskService.createTask(newTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks(){
        List<TaskResponseDTO> tasks = taskService.getAllTasks();
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskByID(@PathVariable("id") UUID task_id){
        TaskResponseDTO task = taskService.getTaskById(task_id);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@RequestBody TaskRequestDTO newTask, @PathVariable("id") UUID task_id){
        TaskResponseDTO task = taskService.updateTask(newTask, task_id);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") UUID task_id){
        taskService.deleteTask(task_id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
