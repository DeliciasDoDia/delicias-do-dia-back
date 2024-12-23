// Geovanna da Silva Lima - 10420059
// Pedro Henrique Mansano Fernandes - 10388037

package com.mackenzie.receitas.portal_receitas.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mackenzie.receitas.portal_receitas.entities.Recipe;
import com.mackenzie.receitas.portal_receitas.services.RecipeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api", produces = {"application/json"})
@Tag(name = "Dados de Receitas", description = "Endpoints relacionados a receitas do sistema.")
public class RecipeController {

    private final RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    // CREATE
    @Operation(summary = "Realiza o cadastro de receitas", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro de receita realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o cadastro de receita"),
    })
    @PostMapping("/recipes")
    public ResponseEntity<Recipe> create(@RequestBody Recipe recipe) {
        recipe = service.save(recipe);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(recipe.getId()).toUri();
        return ResponseEntity.created(uri).body(recipe);
    }

    // READ
    @Operation(summary = "Busca dados de receita por id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/recipes/{id}")
    public ResponseEntity<Recipe> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    // GET http://localhost:8080/api/recipes
    // GET http://localhost:8080/api/recipes?catName=nome
    @Operation(summary = "Busca dados de receita por nome de categoria ou busca todas as receitas se não houver o nome da categoria", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/recipes")
    public ResponseEntity<List<Recipe>> findByCategory(@RequestParam(required = false) String catName) {
        if (catName == null) {
            List<Recipe> list = service.findAll();
            return ResponseEntity.ok().body(list);
        }
        List<Recipe> list = service.findByCategory(catName);
        return ResponseEntity.ok().body(list);
    }

    // GET http://localhost:8080/api/recipes/user/2
    // GET http://localhost:8080/api/recipes/user/2?catName=molho
    @Operation(summary = "Busca dados de receita por ID de usuário", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/recipes/user/{userId}")
    public ResponseEntity<List<Recipe>> findByUserAndCategory(@RequestParam(required = false) String catName, @PathVariable long userId) {
        if (catName == null) {
            List<Recipe> list = service.findByAuthorId(userId);
            return ResponseEntity.ok().body(list);
        }
        List<Recipe> list = service.findByAuthorAndCategory(userId, catName);
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Busca dados de receita por nome de ingrediente", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/recipes/ingredient/{ingName}")
    public ResponseEntity<List<Recipe>> findByIngredient(@PathVariable String ingName) {
        List<Recipe> list = service.findByIngredient(ingName);
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Busca dados de receita pelo nome dela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/recipes/name/{name}")
    public ResponseEntity<List<Recipe>> findByName(@PathVariable String name) {
        List<Recipe> list = service.findByName(name);
        return ResponseEntity.ok().body(list);
    }

    // UPDATE
    @Operation(summary = "Atualiza os dados de uma receita", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Receita atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Receita não encontrada"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar os dados da receita"),
    })
    @PutMapping("/recipes/{id}")
    public ResponseEntity<Recipe> update(@PathVariable Long id, @RequestBody Recipe recipe) {
        return ResponseEntity.ok().body(service.update(id, recipe));
    }

    // DELETE
    @Operation(summary = "Exclui uma receita por id", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Receita excluída com sucesso"),
            @ApiResponse(responseCode = "404", description = "Receita não encontrada"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro ao excluir a receita"),
    })
    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
