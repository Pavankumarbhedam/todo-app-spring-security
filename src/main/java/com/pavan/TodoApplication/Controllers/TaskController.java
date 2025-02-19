package com.pavan.TodoApplication.Controllers;

import com.pavan.TodoApplication.Models.Task;
import com.pavan.TodoApplication.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public String getTask(Model model)
    {
        List<Task> tasks=taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping("/tasks")
    public String getTask(@RequestParam  String title)
    {
       taskService.addTask(title);
        return "redirect:/tasks";
    }

    @GetMapping ("/tasks/{id}/delete")
    public String deleteTask(@PathVariable Long id)
    {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping ("/tasks/{id}/toggle")
    public String toggleTask(@PathVariable Long id) throws IllegalAccessException {
        taskService.toggleTask(id);
        return "redirect:/tasks";
    }
}
