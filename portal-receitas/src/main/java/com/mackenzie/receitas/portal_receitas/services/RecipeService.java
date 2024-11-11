// Geovanna da Silva Lima - 10420059
// Pedro Henrique Mansano Fernandes - 10388037

package com.mackenzie.receitas.portal_receitas.services;

import com.mackenzie.receitas.portal_receitas.entities.Recipe;
import com.mackenzie.receitas.portal_receitas.exceptions.ResourceNotFoundException;
import com.mackenzie.receitas.portal_receitas.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public List<Recipe> findAll() {
        return repository.findAll();
    }

    public Recipe findById(Long id) {
        Optional<Recipe> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Recipe> findByCategory(String catName) {
        return repository.findByCategoryNameContainingIgnoreCase(catName);
    }

    public List<Recipe> findByIngredient(String ingName) {
        return repository.findByIngredientsNameContainingIgnoreCase(ingName);
    }

    public Recipe save(Recipe recipe) {
        return repository.save(recipe);
    }

    public Recipe update(Long id, Recipe recipe) {
        Recipe entity = repository.getReferenceById(id);
        entity.setName(recipe.getName());
        entity.setImageUrl(recipe.getImageUrl());
        entity.setDescription(recipe.getDescription());
        entity.setPrepTimeMinutes(recipe.getPrepTimeMinutes());
        entity.setServings(recipe.getServings());
        entity.setCategory(recipe.getCategory());
        entity.setDifficulty(recipe.getDifficulty());
        entity.setCost(recipe.getCost());
        entity.getSteps().clear();
        entity.getSteps().addAll(recipe.getSteps());
        entity.getIngredients().clear();
        entity.getIngredients().addAll(recipe.getIngredients());
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
