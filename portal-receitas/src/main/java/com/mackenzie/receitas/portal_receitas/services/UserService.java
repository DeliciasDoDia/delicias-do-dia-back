// Geovanna da Silva Lima - 10420059
// Pedro Henrique Mansano Fernandes - 10388037

package com.mackenzie.receitas.portal_receitas.services;

import com.mackenzie.receitas.portal_receitas.entities.User;
import com.mackenzie.receitas.portal_receitas.exceptions.DatabaseException;
import com.mackenzie.receitas.portal_receitas.exceptions.ResourceNotFoundException;
import com.mackenzie.receitas.portal_receitas.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User findByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User update(Long id, User user) {
        try {
            User entity = repository.getReferenceById(id);
            entity.setName(user.getName());
            entity.setEmail(user.getEmail());
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void delete(Long id) {
        Optional<User> obj = repository.findById(id);
        if (!obj.isPresent()) throw new ResourceNotFoundException(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
