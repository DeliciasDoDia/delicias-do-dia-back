package com.mackenzie.receitas.portal_receitas.repositories;

import com.mackenzie.receitas.portal_receitas.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
