package com.Todo.Todoapp.Controller;

import com.Todo.Todoapp.Model.Task;
import com.Todo.Todoapp.Service.TaskServices;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {
    private  final TaskServices taskServices;

    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @GetMapping
    public String getTasks(Model model){
        List<Task> listofTask = taskServices.getAllTask();
        model.addAttribute("tasks",listofTask);
        return "tasks";
    }

    @PostMapping
    public String createTask(@RequestParam String title ){
        taskServices.createTask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deletetask(@PathVariable Long id){
        taskServices.deleteTask(id);
        return "redirect:/";

    }

    @GetMapping("/{id}/toggle")
    public String toggletask(@PathVariable Long id){
        taskServices.toogletask(id);
        return "redirect:/";

    }


}
