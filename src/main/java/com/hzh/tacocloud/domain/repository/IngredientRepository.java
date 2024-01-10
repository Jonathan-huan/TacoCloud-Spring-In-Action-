package com.hzh.tacocloud.domain.repository;

import com.hzh.tacocloud.domain.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
