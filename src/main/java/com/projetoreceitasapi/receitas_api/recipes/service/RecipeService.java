package com.projetoreceitasapi.receitas_api.recipes.service;

import com.projetoreceitasapi.receitas_api.recipes.model.Recipe;
import com.projetoreceitasapi.receitas_api.recipes.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    //precisa salvar no banco
    public Recipe saveRecipe(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    //precisa deletar do banco
    public String deleteRecipe(Long id){
        if (!recipeRepository.existsById(id)){
            throw new IllegalArgumentException("Recipe ID "+id+" not found.");
        }
        recipeRepository.deleteById(id);

        return "Recipe ID "+id+" deleted.";
    }

    //precisa atualizar no banco
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

    //precisa buscar no banco
    public Optional<Recipe> findById(Long id){
        return recipeRepository.findById(id);
    }

    //precisa buscar todos no banco
    public List<Recipe> findAll(){
        return recipeRepository.findAll();
    }

}
