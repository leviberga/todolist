package com.leviberga.todolist.service;

import com.leviberga.todolist.dto.TaskRequestDTO;
import com.leviberga.todolist.dto.TaskResponseDTO;
import com.leviberga.todolist.exception.TaskNotFoundException;
import com.leviberga.todolist.mapper.TaskMapper;
import com.leviberga.todolist.model.Tasks;
import com.leviberga.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper){
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO){
        Tasks task = taskMapper.toEntity(taskRequestDTO);
        Tasks savedTask = taskRepository.save(task);
        return taskMapper.toResponseDTO(savedTask);
    }
    public List<TaskResponseDTO> getAllTasks(){
        List<Tasks> tasks = taskRepository.findAll();
        return tasks.stream().map(taskMapper::toResponseDTO).toList();
    }
    public TaskResponseDTO getTaskById(UUID task_id){
         Tasks task = taskRepository.findById(task_id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with the following ID: " + task_id));
         return taskMapper.toResponseDTO(task);
    }
    public TaskResponseDTO updateTask(TaskRequestDTO taskRequestDTO, UUID task_id){
        Tasks task = taskRepository.findById(task_id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with the following ID: " + task_id));
        taskMapper.updateEntity(taskRequestDTO, task);
        Tasks savedTask = taskRepository.save(task);
        return taskMapper.toResponseDTO(savedTask);
    }
    public void deleteTask(UUID task_id){
        Tasks task = taskRepository.findById(task_id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with the following ID: " + task_id));
        taskRepository.delete(task);
    }
}
