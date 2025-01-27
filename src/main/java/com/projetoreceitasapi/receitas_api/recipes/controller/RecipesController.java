package com.projetoreceitasapi.receitas_api.recipes.controller;

import com.projetoreceitasapi.receitas_api.recipes.model.Recipe;
import com.projetoreceitasapi.receitas_api.recipes.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The type Recipes controller.
 */
@RestController
@RequestMapping("api/recipes")
public class RecipesController {

    private final RecipeService recipeService;

    public RecipesController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello");
    }

    @PostMapping("/save")
    public ResponseEntity<Recipe> saveRecipe(@Valid @RequestBody Recipe recipe) {
        Recipe savedRecipe = recipeService.saveRecipe(recipe);
        //v1
        //v2 ResponseEntity.status(HttpStatus.CREATED).body(savedRecipe)
        return ResponseEntity.ok(savedRecipe);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable Long id) {
        try{
            recipeService.deleteRecipe(id);
            return ResponseEntity.ok("Deleted");
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @Valid @RequestBody Recipe recipe) {
        Optional<Recipe> updatedRecipe = Optional.ofNullable(recipeService.update(id, recipe));
        return updatedRecipe.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Recipe> findRecipeById(@PathVariable Long id) {
        Optional<Recipe> recipe = recipeService.findById(id);
        return recipe.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @GetMapping("/all")
    public ResponseEntity<List> findAll() {
        List<Recipe> recipes = recipeService.findAll();
        return ResponseEntity.ok(recipes);
    }
}
