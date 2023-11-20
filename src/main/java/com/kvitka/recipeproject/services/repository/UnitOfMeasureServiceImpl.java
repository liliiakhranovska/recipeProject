package com.kvitka.recipeproject.services.repository;

import com.kvitka.recipeproject.domain.UnitOfMeasure;
import com.kvitka.recipeproject.repositories.UnitOfMeasureRepository;
import com.kvitka.recipeproject.services.UnitOfMeasureService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService<UnitOfMeasure, Long> {

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public Iterable<UnitOfMeasure> findAll() {
        return unitOfMeasureRepository.findAll();
    }

    @Override
    public Optional<UnitOfMeasure> findById(Long id) {
        return unitOfMeasureRepository.findById(id);
    }

    @Override
    public UnitOfMeasure save(UnitOfMeasure uom) {
        return unitOfMeasureRepository.save(uom);
    }

    @Override
    public void delete(UnitOfMeasure uom) {
        unitOfMeasureRepository.save(uom);
    }

    @Override
    public void deleteById(Long id) {
        unitOfMeasureRepository.deleteById(id);
    }

    @Override
    public Optional<UnitOfMeasure> findByDescription(String description) {
        return unitOfMeasureRepository.findByDescription(description);
    }
}
