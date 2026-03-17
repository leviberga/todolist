package com.leviberga.todolist.mapper;

import com.leviberga.todolist.dto.TaskRequestDTO;
import com.leviberga.todolist.dto.TaskResponseDTO;
import com.leviberga.todolist.model.Tasks;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public Tasks toEntity(TaskRequestDTO dto) {
        Tasks task = new Tasks();
        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setIsDone(dto.getIsDone());
        task.setPriority(dto.getPriority());
        return task;
    }
    public TaskResponseDTO toResponseDTO(Tasks task) {
        TaskResponseDTO response = new TaskResponseDTO();
        response.setId(task.getId());
        response.setName(task.getName());
        response.setDescription(task.getDescription());
        response.setIsDone(task.getIsDone());
        response.setPriority(task.getPriority());
        return response;
    }
    public void updateEntity(TaskRequestDTO dto, Tasks task) {
        if (dto == null) return;

        if (dto.getName() != null) {
            task.setName(dto.getName());
        }
        if (dto.getDescription() != null) {
            task.setDescription(dto.getDescription());
        }
        if (dto.getIsDone() != null) {
            task.setIsDone(dto.getIsDone());
        }
        if (dto.getPriority() != null) {
            task.setPriority(dto.getPriority());
        }
    }
}
