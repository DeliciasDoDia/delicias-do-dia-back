package com.mackenzie.receitas.portal_receitas.controllers;

import com.mackenzie.receitas.portal_receitas.entities.Category;
import com.mackenzie.receitas.portal_receitas.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    // READ
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAll() {
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

}
