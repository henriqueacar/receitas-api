package com.projetoreceitasapi.receitas_api.recipes.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Entity
@Getter
@Setter
@Table(name = "recipe")
public class recipe {

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
}
