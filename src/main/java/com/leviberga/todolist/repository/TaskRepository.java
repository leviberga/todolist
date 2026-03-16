package com.leviberga.todolist.repository;

import com.leviberga.todolist.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Tasks, UUID> {
}
