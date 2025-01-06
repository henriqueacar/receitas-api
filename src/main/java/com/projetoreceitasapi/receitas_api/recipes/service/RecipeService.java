package com.projetoreceitasapi.receitas_api.recipes.service;

import com.projetoreceitasapi.receitas_api.recipes.model.Recipe;
import com.projetoreceitasapi.receitas_api.recipes.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Recipe service.
 */
@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    /**
     * Instantiates a new Recipe service.
     *
     * @param recipeRepository the recipe repository
     */
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    /**
     * Save recipe recipe.
     *
     * @param recipe the recipe
     * @return the recipe
     */
    public Recipe saveRecipe(Recipe recipe){
        return recipeRepository.save(recipe);
    }


    /**
     * Delete recipe string.
     *
     * @param id the id
     * @return the string
     */
    public void deleteRecipe(Long id){
        if (!recipeRepository.existsById(id)){
            throw new IllegalArgumentException("Recipe ID "+id+" not found.");
        }
        recipeRepository.deleteById(id);

    }


    /**
     * Update recipe.
     *
     * @param id     the id
     * @param recipe the recipe
     * @return the recipe
     */
    public Recipe update(Long id, Recipe recipe){
        Recipe entity = recipeRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Recipe ID "+id+" not found.")
                );

        entity.setName(recipe.getName());
        entity.setDescription(recipe.getDescription());
        entity.setDifficulty(recipe.getDifficulty());
        entity.setIngredients(recipe.getIngredients());
        return recipeRepository.save(entity);
    }


    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<Recipe> findById(Long id){
        return recipeRepository.findById(id);
    }


    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Recipe> findAll(){
        return recipeRepository.findAll();
    }

}
