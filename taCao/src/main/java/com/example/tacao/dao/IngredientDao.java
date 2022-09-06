package com.example.tacao.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IngredientDao extends CrudRepository<Ingredient, Long> {

    List<Ingredient> findByName(String name);
}
