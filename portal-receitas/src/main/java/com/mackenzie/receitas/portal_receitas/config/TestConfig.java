// Geovanna da Silva Lima - 10420059
// Pedro Henrique Mansano Fernandes - 10388037

package com.mackenzie.receitas.portal_receitas.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mackenzie.receitas.portal_receitas.entities.Category;
import com.mackenzie.receitas.portal_receitas.entities.Ingredient;
import com.mackenzie.receitas.portal_receitas.entities.Recipe;
import com.mackenzie.receitas.portal_receitas.entities.User;
import com.mackenzie.receitas.portal_receitas.repositories.CategoryRepository;
import com.mackenzie.receitas.portal_receitas.repositories.IngredientRepository;
import com.mackenzie.receitas.portal_receitas.repositories.RecipeRepository;
import com.mackenzie.receitas.portal_receitas.repositories.UserRepository;

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

        Category cat1 = new Category(null, "Bolos e Tortas", "https://drive.usercontent.google.com/download?id=189X_KFDLemwa45QpVupeOC6GhK7tSx22");
        Category cat2 = new Category(null, "Carnes", "https://drive.usercontent.google.com/download?id=10kPp9AuVdoe2bUUODQvDpdAnGrcWg_Wb");
        Category cat3 = new Category(null, "Massas", "https://drive.usercontent.google.com/download?id=1D_QnPJalC1TxyXEoQn3UXRmPDZouBU20");
        Category cat4 = new Category(null, "Lanches", "https://drive.usercontent.google.com/download?id=1UnW6eOo3ynnM6SwL8uilEclK_XtkWR3w");
        Category cat5 = new Category(null, "Sobremesas", "https://drive.usercontent.google.com/download?id=1i4srtUfZ0japhJxYCSCLrmL9NMuMw1RK");
        Category cat6 = new Category(null, "Aves","https://drive.usercontent.google.com/download?id=1KiqNd28s8EZLKwGfIsKbh4T10p2frOkL" );
        Category cat7 = new Category(null, "Peixes e Frutos do Mar","https://drive.usercontent.google.com/download?id=1EDw0Z96MDhDm-bJDsnMa1CQWhhY1w6Id");
        Category cat8 = new Category(null, "Saladas e Molhos", "https://drive.usercontent.google.com/download?id=1N6HnTOvEBZ08G3cVd_rE5EUA2UZzePE8&export=view&authuser=0");
        Category cat9 = new Category(null, "Sopas","https://drive.usercontent.google.com/download?id=1Q9NUD1p30bz8E0wABMJqOngEDBy1Wr82" );
        Category cat10 = new Category(null, "Bebidas", "https://drive.usercontent.google.com/download?id=1F4yTuuWZ7ydsaWE1ud2q6Xg8K-jkjXdu");
        Category cat11 = new Category(null, "Outros", "https://drive.usercontent.google.com/download?id=1uXiufBaSfZEpKN1ZtZhq6Hh6L4qNZrI3");

        Ingredient i1 = new Ingredient(null, "Sal");
        Ingredient i2 = new Ingredient(null, "Pimenta do reino");
        Ingredient i3 = new Ingredient(null, "Mortandela");
        Ingredient i4 = new Ingredient(null, "Farinha de trigo");
        Ingredient i5 = new Ingredient(null, "Suco de laranja");
        Ingredient i6 = new Ingredient(null, "Fermento");
        Ingredient i7 = new Ingredient(null, "Açucar");
        Ingredient i8 = new Ingredient(null, "Ovo");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        ingredientRepository.saveAll(Arrays.asList(i1, i2, i3, i4, i5, i6, i7, i8));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10, cat11));

        Recipe r1 = new Recipe(null, "Frango com Curry", "imageLink",
                "blablabla", 40, 4, 2, 3, cat2, u1, "t");

        Recipe r2 = new Recipe(null, "Molho pesto", "imageLink",
                "bla", 15, 2, 2, 3, cat8, u2, "step");

        Recipe r3 = new Recipe(null, "Molho branco", "imageLink",
                "bla", 15, 2, 2, 4, cat8, u3, "step");

        Recipe r4 = new Recipe(null, "Bolo de Laranja", "https://p2.trrsf.com/image/fget/cf/1200/900/middle/images.terra.com/2023/05/02/bolo-laranja-ursdzhu7qmur.jpg",
                "Fazer um bolo de laranja delicioso é uma maneira maravilhosa de surpreender a família com um lanche saboroso. Esta receita simples e prática promete conquistar o paladar de todos com seu aroma cítrico e sabor inconfundível."
                , 50, 10, 2, 1, cat1, u3, "step");

        r1.getIngredients().add(i1);
        r2.addIngredients(Arrays.asList(i1,i2, i3));
        r3.addIngredients(Arrays.asList(i1,i2));
        r4.addIngredients(Arrays.asList(i4,i5,i6,i7,i8));

        recipeRepository.saveAll(Arrays.asList(r1, r2, r3, r4));
    }
}
