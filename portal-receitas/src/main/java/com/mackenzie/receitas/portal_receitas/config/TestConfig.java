package com.mackenzie.receitas.portal_receitas.config;

import com.mackenzie.receitas.portal_receitas.entities.Category;
import com.mackenzie.receitas.portal_receitas.entities.Ingredient;
import com.mackenzie.receitas.portal_receitas.entities.Recipe;
import com.mackenzie.receitas.portal_receitas.entities.User;
import com.mackenzie.receitas.portal_receitas.repositories.CategoryRepository;
import com.mackenzie.receitas.portal_receitas.repositories.IngredientRepository;
import com.mackenzie.receitas.portal_receitas.repositories.RecipeRepository;
import com.mackenzie.receitas.portal_receitas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria", "maria@gmail.com", "12345");
        User u2 = new User(null, "Jorge", "jorge@gmail.com", "12345");
        User u3 = new User(null, "Robirso", "robirso@gmail.com", "12345");

        Category cat1 = new Category(null, "Aves");
        Category cat2 = new Category(null, "Molhos");

        Ingredient i1 = new Ingredient(null, "Sal");
        Ingredient i2 = new Ingredient(null, "Pimenta do reino");
        Ingredient i3 = new Ingredient(null, "Mortandela");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        ingredientRepository.saveAll(Arrays.asList(i1, i2, i3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2));

        Recipe r1 = new Recipe(null, "Frango com Curry", "imageLink",
                "blablabla", 40, 4, cat1, u2);

        Recipe r2 = new Recipe(null, "Molho pesto", "imageLink",
                "bla", 15, 2, cat2, u3);

        Recipe r3 = new Recipe(null, "Molho branco", "imageLink",
                "bla", 15, 2, cat2, u3);

        r1.getIngredients().add(i1);
        r2.getIngredients().add(i1);
        r2.getIngredients().add(i2);
        r2.getIngredients().add(i3);
        r3.getIngredients().add(i1);
        r3.getIngredients().add(i2);

        recipeRepository.saveAll(Arrays.asList(r1, r2, r3));
    }
}
