package com.leviberga.todolist.dto;

import com.leviberga.todolist.enums.PriorityType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TaskResponseDTO {
    private UUID id;
    private String name;
    private String description;
    private Boolean isDone;
    private PriorityType priority;
}
