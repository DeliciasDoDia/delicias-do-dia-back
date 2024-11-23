// Geovanna da Silva Lima - 10420059
// Pedro Henrique Mansano Fernandes - 10388037

package com.mackenzie.receitas.portal_receitas.repositories;

import com.mackenzie.receitas.portal_receitas.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByCategoryNameContainingIgnoreCase(String name);

    List<Recipe> findByNameContainingIgnoreCase(String name);

    List<Recipe> findByIngredientsNameContainingIgnoreCase(String name);
}
