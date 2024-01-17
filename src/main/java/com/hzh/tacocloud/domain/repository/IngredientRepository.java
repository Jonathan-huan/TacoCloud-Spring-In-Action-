package com.hzh.tacocloud.domain.repository;

import com.hzh.tacocloud.domain.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {

}
