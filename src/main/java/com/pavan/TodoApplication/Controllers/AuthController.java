package com.pavan.TodoApplication.Controllers;

import com.pavan.TodoApplication.Models.Users;
import com.pavan.TodoApplication.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.rmi.registry.Registry;

@Controller
public class AuthController {
   @Autowired
   private UserRepo userRepo;

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
    @GetMapping("/register")
    public String register()
    {
        return "register";
    }
    @PostMapping("/register")
    public String register(@RequestParam String username,@RequestParam String password)
    {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
       // System.out.println("Hello world");
        Users user=new Users();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        userRepo.save(user);
        return "redirect:/login";
    }

}
