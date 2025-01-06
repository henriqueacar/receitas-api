package com.projetoreceitasapi.receitas_api.recipes.repository;

import com.projetoreceitasapi.receitas_api.recipes.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Recipe repository.
 */
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
