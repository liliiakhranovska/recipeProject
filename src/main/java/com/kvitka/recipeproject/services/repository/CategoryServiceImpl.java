package com.kvitka.recipeproject.services.repository;

import com.kvitka.recipeproject.domain.Category;
import com.kvitka.recipeproject.repositories.CategoryRepository;
import com.kvitka.recipeproject.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService<Category, Long> {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
