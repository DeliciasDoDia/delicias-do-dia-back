package com.mackenzie.receitas.portal_receitas.repositories;

import com.mackenzie.receitas.portal_receitas.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByCategory_Id(Long id);

}
