// Geovanna da Silva Lima - 10420059
// Pedro Henrique Mansano Fernandes - 10388037

package com.mackenzie.receitas.portal_receitas.services;

import com.mackenzie.receitas.portal_receitas.entities.Recipe;
import com.mackenzie.receitas.portal_receitas.exceptions.ResourceNotFoundException;
import com.mackenzie.receitas.portal_receitas.repositories.RecipeRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public List<Recipe> findByAuthorAndCategory(long userId, String catName) {
        return repository.findByAuthorIdAndCategoryNameContainingIgnoreCase(userId, catName);
    }

    public List<Recipe> findByAuthorId(long userId) {
        return repository.findByAuthorId(userId);
    }

    public List<Recipe> findByIngredient(String ingName) {
        return repository.findByIngredientsNameContainingIgnoreCase(ingName);
    }

    public List<Recipe> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }


    public Recipe save(Recipe recipe) {
        return repository.save(recipe);
    }

    public Recipe update(Long id, Recipe recipe) {
        try {
            Recipe entity = repository.getReferenceById(id);
            entity.setName(recipe.getName());
            entity.setImageUrl(recipe.getImageUrl());
            entity.setDescription(recipe.getDescription());
            entity.setPrepTimeMinutes(recipe.getPrepTimeMinutes());
            entity.setServings(recipe.getServings());
            entity.setCategory(recipe.getCategory());
            entity.setDifficulty(recipe.getDifficulty());
            entity.setCost(recipe.getCost());
            entity.setSteps(recipe.getSteps());
            entity.getIngredients().clear();
            entity.getIngredients().addAll(recipe.getIngredients());
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void delete(Long id) {
        Optional<Recipe> obj = repository.findById(id);
        if (!obj.isPresent()) throw new ResourceNotFoundException(id);
        repository.deleteById(id);
    }
}
