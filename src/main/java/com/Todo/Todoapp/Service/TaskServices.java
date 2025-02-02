package com.Todo.Todoapp.Service;

import com.Todo.Todoapp.Model.Task;
import com.Todo.Todoapp.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {
    private final TaskRepository taskRepository;

    public TaskServices(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task>getAllTask(){
        return taskRepository.findAll();

    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
         taskRepository.deleteById(id);
    }

    public void toogletask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Task id "));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);


    }
}
