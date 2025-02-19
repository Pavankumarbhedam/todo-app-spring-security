package com.pavan.TodoApplication.Service;

import com.pavan.TodoApplication.Models.MyUserDetails;
import com.pavan.TodoApplication.Models.Users;
import com.pavan.TodoApplication.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService  implements UserDetailsService {


    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username)
    {

        Users user=userRepo.findByUsername(username);
        if(user==null)
             throw new UsernameNotFoundException("user not found");
        return new MyUserDetails(user);
}
}
