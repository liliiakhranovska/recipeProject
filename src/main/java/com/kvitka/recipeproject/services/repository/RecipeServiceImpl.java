package com.kvitka.recipeproject.services.repository;

import com.kvitka.recipeproject.domain.Recipe;
import com.kvitka.recipeproject.repositories.RecipeRepository;
import com.kvitka.recipeproject.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService<Recipe, Long> {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Iterable<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void delete(Recipe recipe) {
        recipeRepository.delete(recipe);
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }
}
