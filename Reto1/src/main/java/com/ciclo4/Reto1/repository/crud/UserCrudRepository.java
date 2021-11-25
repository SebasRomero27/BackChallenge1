package com.ciclo4.Reto1.repository.crud;

import com.ciclo4.Reto1.model.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

// Crud repository implements the validations to find by email and by password combination

public interface UserCrudRepository extends CrudRepository<User, Integer>
{
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
}
