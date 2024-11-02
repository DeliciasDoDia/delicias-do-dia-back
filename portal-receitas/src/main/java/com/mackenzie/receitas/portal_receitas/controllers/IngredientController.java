package com.mackenzie.receitas.portal_receitas.controllers;

import com.mackenzie.receitas.portal_receitas.entities.Ingredient;
import com.mackenzie.receitas.portal_receitas.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IngredientController {

    private final IngredientService service;

    public IngredientController(IngredientService service) {
        this.service = service;
    }

    // READ
    @GetMapping("/ingredients")
    public ResponseEntity<List<Ingredient>> getAll() {
        List<Ingredient> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/ingredients/{id}")
    public ResponseEntity<Ingredient> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

}
