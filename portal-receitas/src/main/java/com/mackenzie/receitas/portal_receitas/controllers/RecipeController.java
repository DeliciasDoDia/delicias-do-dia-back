package com.mackenzie.receitas.portal_receitas.controllers;

import com.mackenzie.receitas.portal_receitas.entities.Recipe;
import com.mackenzie.receitas.portal_receitas.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeController {

    private final RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping("/recipes")
    public ResponseEntity<Recipe> create(@RequestBody Recipe recipe) {
        recipe = service.save(recipe);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(recipe.getId()).toUri();
        return ResponseEntity.created(uri).body(recipe);
    }

    // READ
    @GetMapping("/recipes")
    public ResponseEntity<List<Recipe>> getAll() {
        List<Recipe> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<Recipe> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping("/recipes/category/{id}")
    public ResponseEntity<List<Recipe>> findByCategory(@PathVariable long id) {
        List<Recipe> list = service.findByCategory(id);
        return ResponseEntity.ok().body(list);
    }

    // UPDATE
    @PutMapping("/recipes/{id}")
    public ResponseEntity<Recipe> update(@PathVariable Long id, @RequestBody Recipe recipe) {
        return ResponseEntity.ok().body(service.update(id, recipe));
    }

    // DELETE
    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
