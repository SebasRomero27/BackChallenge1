package com.ciclo4.Reto1.Service;

//

import java.util.*;
import com.ciclo4.Reto1.model.User;
import com.ciclo4.Reto1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService 
{
    @Autowired
    private UserRepository userRepository;
    
    public List <User> getAll()
    {
        return userRepository.getAll();
    }
    
    public Optional <User> getUser (int id)
    {
        return userRepository.getUser(id);
    }
    
    public User register (User user)
    {
        if (user.getId() == null)
        {
            if (emailExistence(user.getEmail()) == false)
            {
                return userRepository.save(user);
            }
            else
            {
                return user;
            }
        }
        else
            {
                return user;
            }
    }
    
    public boolean emailExistence(String email) {
        return userRepository.emailExistence(email);
    }
    
    public User autheticateUser(String email, String password) {
        Optional<User> user = userRepository.autheticateUser(email, password);

        if (user.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
        } else {
            return user.get();
        }
    }    
}

    