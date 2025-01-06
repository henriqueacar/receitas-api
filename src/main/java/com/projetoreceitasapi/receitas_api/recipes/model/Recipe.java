package com.projetoreceitasapi.receitas_api.recipes.model;

import jakarta.persistence.*;


import java.io.Serial;
import java.io.Serializable;

/**
 * The type Recipe.
 */
@Entity
@Table(name = "recipe")
public class Recipe implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false,length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Difficulty difficulty;

    @Column(nullable = false, length = 1000)
    private String ingredients;

    @Column(name = "prep_time")
    private Integer prepTime;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets difficulty.
     *
     * @return the difficulty
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * Sets difficulty.
     *
     * @param difficulty the difficulty
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Gets ingredients.
     *
     * @return the ingredients
     */
    public String getIngredients() {
        return ingredients;
    }

    /**
     * Sets ingredients.
     *
     * @param ingredients the ingredients
     */
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Gets prep time.
     *
     * @return the prep time
     */
    public Integer getPrepTime() {
        return prepTime;
    }

    /**
     * Sets prep time.
     *
     * @param prepTime the prep time
     */
    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }
}
