// Geovanna da Silva Lima - 10420059
// Pedro Henrique Mansano Fernandes - 10388037

package com.mackenzie.receitas.portal_receitas.controllers;

import java.net.URI;
import java.util.List;

import com.mackenzie.receitas.portal_receitas.entities.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mackenzie.receitas.portal_receitas.entities.Ingredient;
import com.mackenzie.receitas.portal_receitas.services.IngredientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/api", produces = {"application/json"})
@Tag(name = "Dados de Ingredientes", description = "Endpoints relacionados aos ingredientes da receita.")
public class IngredientController {

    private final IngredientService service;

    public IngredientController(IngredientService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping("/ingredients")
    public ResponseEntity<Ingredient> create(@RequestBody Ingredient ingredient) {
        ingredient = service.save(ingredient);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(ingredient.getId()).toUri();
        return ResponseEntity.created(uri).body(ingredient);
    }

    // READ
    @Operation(summary = "Busca dados dos ingredientes", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
        @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
        @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/ingredients")
    public ResponseEntity<List<Ingredient>> getAll() {
        List<Ingredient> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Busca dados dos ingredientes por id", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
        @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
        @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/ingredients/{id}")
    public ResponseEntity<Ingredient> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping("/ingredients/name/{name}")
    public ResponseEntity<Ingredient> findByName(@PathVariable String name) {
        return ResponseEntity.ok().body(service.findByName(name));
    }

}
