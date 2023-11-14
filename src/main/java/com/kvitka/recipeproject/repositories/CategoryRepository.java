package com.kvitka.recipeproject.repositories;

import com.kvitka.recipeproject.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
