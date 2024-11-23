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

        Category bolosETortas = new Category(null, "Bolos e Tortas", "https://drive.usercontent.google.com/download?id=189X_KFDLemwa45QpVupeOC6GhK7tSx22");
        Category carnes = new Category(null, "Carnes", "https://drive.usercontent.google.com/download?id=10kPp9AuVdoe2bUUODQvDpdAnGrcWg_Wb");
        Category massas = new Category(null, "Massas", "https://drive.usercontent.google.com/download?id=1D_QnPJalC1TxyXEoQn3UXRmPDZouBU20");
        Category lanches = new Category(null, "Lanches", "https://drive.usercontent.google.com/download?id=1UnW6eOo3ynnM6SwL8uilEclK_XtkWR3w");
        Category sobremesas = new Category(null, "Sobremesas", "https://drive.usercontent.google.com/download?id=1i4srtUfZ0japhJxYCSCLrmL9NMuMw1RK");
        Category aves = new Category(null, "Aves", "https://drive.usercontent.google.com/download?id=1KiqNd28s8EZLKwGfIsKbh4T10p2frOkL");
        Category peixesEFrutosDoMar = new Category(null, "Peixes e Frutos do Mar", "https://drive.usercontent.google.com/download?id=1EDw0Z96MDhDm-bJDsnMa1CQWhhY1w6Id");
        Category saladasEMolhos = new Category(null, "Saladas e Molhos", "https://drive.usercontent.google.com/download?id=1N6HnTOvEBZ08G3cVd_rE5EUA2UZzePE8&export=view&authuser=0");
        Category sopas = new Category(null, "Sopas", "https://drive.usercontent.google.com/download?id=1Q9NUD1p30bz8E0wABMJqOngEDBy1Wr82");
        Category bebidas = new Category(null, "Bebidas", "https://drive.usercontent.google.com/download?id=1F4yTuuWZ7ydsaWE1ud2q6Xg8K-jkjXdu");
        Category outros = new Category(null, "Outros", "https://drive.usercontent.google.com/download?id=1uXiufBaSfZEpKN1ZtZhq6Hh6L4qNZrI3");

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
        categoryRepository.saveAll(Arrays.asList(bolosETortas, carnes, massas, lanches, sobremesas, aves, peixesEFrutosDoMar, saladasEMolhos, sopas, bebidas, outros));

        Recipe frangoCurry = new Recipe(null, "Frango com Curry", "https://www.sabornamesa.com.br/media/k2/items/cache/78468ad5288d433009367eeff5a5f3b3_XL.jpg",
                "Frango com curry é um prato cheio de sabor e aroma, que combina a maciez do frango com a especiaria indiana curry, rica em nuances e capaz de transformar qualquer refeição. A combinação de ingredientes pode variar, mas geralmente inclui:",
                40, 4, 2, 3, aves, u1, "testesom");

        Recipe molhoPesto = new Recipe(null, "Molho pesto", "https://static.itdg.com.br/images/1200-630/9585c32e32a16bd069b91ffb3d2f141f/346227-original.jpg",
                "O molho pesto é um clássico da culinária italiana, conhecido por sua cor verde vibrante e sabor intenso. Sua base é composta por manjericão fresco, pinhões, queijo parmesão, azeite extra virgem e alho. Essa combinação resulta em um molho cremoso, aromático e levemente picante, perfeito para acompanhar massas, carnes, legumes grelhados e até mesmo sanduíches.",
                15, 2, 2, 3, saladasEMolhos, u2, "step");

        Recipe molhoDeQueijo = new Recipe(null, "Molho de queijo", "https://cdn0.tudoreceitas.com/pt/posts/9/9/5/molho_de_tres_queijos_2599_600.jpg",
                "O molho de queijo, também conhecido como molho branco ou béchamel, é uma base fundamental na culinária e um acompanhamento delicioso para diversas receitas. Sua versatilidade e sabor cremoso o tornam um favorito tanto para pratos simples quanto para aqueles mais elaborados.",
                15, 2, 2, 4, saladasEMolhos, u3, "step");

        Recipe boloLaranja = new Recipe(null, "Bolo de Laranja", "https://p2.trrsf.com/image/fget/cf/1200/900/middle/images.terra.com/2023/05/02/bolo-laranja-ursdzhu7qmur.jpg",
                "Fazer um bolo de laranja delicioso é uma maneira maravilhosa de surpreender a família com um lanche saboroso. Esta receita simples e prática promete conquistar o paladar de todos com seu aroma cítrico e sabor inconfundível."
                , 50, 10, 2, 1, bolosETortas, u3, "step");

        Recipe negroni = new Recipe(null, "Negroni", "https://feedmechannel.com/wp-content/uploads/2019/06/receita-de-negroni-1024x683.jpg",
                "Negroni é um coquetel clássico italiano, conhecido por sua combinação equilibrada de sabores amargos, doces e cítricos. É um aperitivo elegante e sofisticado, perfeito para apreciadores de coquetéis."
                , 5, 1, 2, 3, bebidas, u3, "step");

        Recipe xtudao = new Recipe(null, "X-Tudão Turbo Master", "https://img77.uenicdn.com/image/upload/v1543484687/service_images/shutterstock_1040760661.jpg",
                "é um sanduíche popular nos lanches e restaurantes brasileiros, conhecido por sua generosidade e variedade de ingredientes. É considerado um lanche completo, capaz de satisfazer qualquer apetite."
                , 30, 1, 2, 3, lanches, u3, "step");

        Recipe sopaDeCebola = new Recipe(null, "Sopa de Cebola", "https://www.portalumami.com.br/app/uploads/2021/11/Sopa-de-cebola01crop.jpg",
                "A sopa de cebola é um prato reconfortante e saboroso, perfeito para os dias mais frios. Com suas camadas de cebola caramelizada, caldo saboroso e um toque de queijo gratinado, essa sopa é capaz de aquecer corpo e alma."
                , 30, 1, 2, 2, sopas, u2, "step");
        Recipe lulaEmpanada = new Recipe(null, "Lula empanada", "https://www.mareriopescados.com.br/uploads/receitas/9bb1c02a62d57aec17efc491c430762a.jpg",
                "A lula empanada é um prato clássico da culinária brasileira, apreciado por muitos por sua textura crocante e sabor marcante. É uma opção perfeita para um lanche, aperitivo ou até mesmo como prato principal, acompanhado de um bom molho tártaro."
                , 30, 13, 2, 2, peixesEFrutosDoMar, u2, "step");

        Recipe chorizo = new Recipe(null, "Bife de chorizo a la parrilla", "https://static.wixstatic.com/media/b0cb4b_d64f289576664be3b8bc0442bbeb5a1f~mv2.jpg/v1/fill/w_980,h_368,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/b0cb4b_d64f289576664be3b8bc0442bbeb5a1f~mv2.jpg",
                "O bife de chorizo à parrilla é um dos cortes mais apreciados na Argentina e em todo o mundo. Sua textura macia, sabor intenso e suculência conquistam qualquer paladar. Para garantir um resultado perfeito, siga estas dicas e prepare um churrasco inesquecível!"
                , 15, 2, 2, 2, carnes, u2, "step");

        Recipe macarrao = new Recipe(null, "Carbonara", "https://guiadacozinha.com.br/wp-content/uploads/2018/04/Receita-de-macarrao-a-carbonara.jpg",
                "A carbonara é um prato italiano simples, mas incrivelmente saboroso, que conquistou paladares ao redor do mundo. Com poucos ingredientes, ela entrega uma explosão de sabor em cada garfada."
                , 25, 3, 2, 2, massas, u2, "step");

        Recipe petitGateau = new Recipe(null, "Petit Gateau", "https://mrbey.com.br/wp-content/uploads/2020/10/petiti-choco.jpg",
                "O petit gateau é um bolinho de chocolate individual que se tornou um clássico da sobremesa. Sua característica principal é o interior cremoso e quente, com um coração derretido de chocolate. É perfeito para quem aprecia um toque de sofisticação e um sabor intenso de chocolate."
                , 15, 1, 2, 2, sobremesas, u2, "step");

        Recipe tijolo = new Recipe(null, "Tijolo salgado", "https://s2.glbimg.com/yC0pNMmiQhN73Ex5-XspmgdalkM=/512x320/smart/e.glbimg.com/og/ed/f/original/2016/08/01/273desejosgravidez273desejosgravidezbm_cf273_desejos_0002_5362_928.jpg",
                "O tijolo salgado é uma ótima opção para quem quer matar a fome sem engordar.", 1, 1, 1, 2, outros, u3, "step");


        frangoCurry.getIngredients().add(i1);
        molhoPesto.addIngredients(Arrays.asList(i1, i2, i3));
        molhoDeQueijo.addIngredients(Arrays.asList(i1, i2));
        boloLaranja.addIngredients(Arrays.asList(i4, i5, i6, i7, i8));

        recipeRepository.saveAll(Arrays.asList(frangoCurry, molhoPesto, molhoDeQueijo, boloLaranja, negroni, xtudao
        , sopaDeCebola, lulaEmpanada, chorizo, macarrao, petitGateau, tijolo));
    }
}
