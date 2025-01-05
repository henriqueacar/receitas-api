package com.projetoreceitasapi.receitas_api.recipes.repository;

import com.projetoreceitasapi.receitas_api.recipes.model.recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<recipe, Long> {
}
