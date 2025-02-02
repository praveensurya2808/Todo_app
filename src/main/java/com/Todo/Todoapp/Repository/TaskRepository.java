package com.Todo.Todoapp.Repository;

import com.Todo.Todoapp.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
