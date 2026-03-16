package com.leviberga.todolist.service;

import com.leviberga.todolist.dto.TaskRequestDTO;
import com.leviberga.todolist.dto.TaskResponseDTO;
import com.leviberga.todolist.mapper.TaskMapper;
import com.leviberga.todolist.model.Tasks;
import com.leviberga.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;

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
}
