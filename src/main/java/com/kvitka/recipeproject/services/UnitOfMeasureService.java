package com.kvitka.recipeproject.services;

import com.kvitka.recipeproject.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureService<UnitOfMeasure, Long> extends CrudService<UnitOfMeasure, Long> {

    Optional<com.kvitka.recipeproject.domain.UnitOfMeasure> findByDescription(String description);
}
