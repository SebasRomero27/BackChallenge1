package com.ciclo4.Reto1.Controller;

import com.ciclo4.Reto1.model.User;
import com.ciclo4.Reto1.Service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService; 

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User register(@RequestBody User user) {
        return userService.register(user);
    }
    
    @GetMapping("/{email}/{password}")
    public User autheticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autheticateUser(email, password);
    }
    
    @GetMapping("/{email}")
    public boolean emailExistence(@PathVariable("email") String email) {
        return userService.emailExistence(email);
    }   
}
