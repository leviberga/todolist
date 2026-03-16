package com.leviberga.todolist.dto;

import com.leviberga.todolist.enums.PriorityType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private Boolean isDone;
    @NotNull
    private PriorityType priority;
}
