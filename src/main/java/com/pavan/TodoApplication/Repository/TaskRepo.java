package com.pavan.TodoApplication.Repository;

import com.pavan.TodoApplication.Models.Task;
import com.pavan.TodoApplication.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task,Long> {
    List<Task> findByUser(Users user);
}
