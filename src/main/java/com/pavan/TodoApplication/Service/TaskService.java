package com.pavan.TodoApplication.Service;

import com.pavan.TodoApplication.Models.Task;
import com.pavan.TodoApplication.Models.Users;
import com.pavan.TodoApplication.Repository.TaskRepo;
import com.pavan.TodoApplication.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private UserRepo userRepo;

    // Get tasks for the logged-in user
    public List<Task> getAllTasks() {
        Users currentUser = getLoggedInUser();
        return taskRepo.findByUser(currentUser);
    }

    // Add a task and associate it with the logged-in user
    public void addTask(String title) {
        Users currentUser = getLoggedInUser(); // Get the logged-in user
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        task.setUser(currentUser); // Associate the task with the user
        taskRepo.save(task); // Save the task with the user reference
    }

    // Delete a task
    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
        System.out.println("Deleted successfully");
    }

    // Toggle task completion status
    public void toggleTask(Long id) {
        Optional<Task> taskFromDb = taskRepo.findById(id);
        if (taskFromDb.isPresent()) {
            Task task = taskFromDb.get();
            task.setCompleted(!task.isCompleted());
            taskRepo.save(task);
        } else {
            throw new IllegalArgumentException("Task not found");
        }
    }

    // Get the logged-in user
    private Users getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Users user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return user;
    }
}
