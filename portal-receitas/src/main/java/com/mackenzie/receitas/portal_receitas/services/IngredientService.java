// Geovanna da Silva Lima - 10420059
// Pedro Henrique Mansano Fernandes - 10388037

package com.mackenzie.receitas.portal_receitas.services;

import com.mackenzie.receitas.portal_receitas.entities.Ingredient;
import com.mackenzie.receitas.portal_receitas.exceptions.ResourceNotFoundException;
import com.mackenzie.receitas.portal_receitas.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository repository;

    public IngredientService(IngredientRepository repository) {
        this.repository = repository;
    }

    public List<Ingredient> findAll() {
        return repository.findAll();
    }

    public Ingredient findById(Long id) {
        Optional<Ingredient> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Ingredient findByName(String name) {
        return repository.findByNameIgnoreCase(name);
    }

    public Ingredient save(Ingredient ingredient) {
        return repository.save(ingredient);
    }
}
