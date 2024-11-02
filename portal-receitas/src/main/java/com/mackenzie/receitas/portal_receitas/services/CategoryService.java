package com.mackenzie.receitas.portal_receitas.services;

import com.mackenzie.receitas.portal_receitas.entities.Category;
import com.mackenzie.receitas.portal_receitas.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
