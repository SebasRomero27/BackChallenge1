package com.ciclo4.Reto1.repository;

// This class implements the verifications to get the the user and save infotmation

import com.ciclo4.Reto1.model.User;
import com.ciclo4.Reto1.repository.crud.UserCrudRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository
{
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    public List<User> getAll()
    {
        return (List<User>) userCrudRepository.findAll();
    }
    
    public Optional<User> getUser (int id)
    {
        return userCrudRepository.findById(id);
    }
    
    public User save (User user)
    {
        return userCrudRepository.save(user);
    }
    
    public boolean emailExistence(String email)
    {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }
    
    public Optional<User> autheticateUser (String email, String password)
    {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
}
