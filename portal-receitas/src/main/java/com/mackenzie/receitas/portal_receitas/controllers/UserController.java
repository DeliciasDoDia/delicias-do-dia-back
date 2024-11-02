package com.mackenzie.receitas.portal_receitas.controllers;

import com.mackenzie.receitas.portal_receitas.entities.User;
import com.mackenzie.receitas.portal_receitas.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestBody User user) {
        user = service.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    // READ
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    // UPDATE
    @PutMapping("/users/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok().body(service.update(id, user));
    }

    // Delete
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
