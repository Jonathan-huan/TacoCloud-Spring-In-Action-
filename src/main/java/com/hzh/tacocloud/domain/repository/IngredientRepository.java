package com.hzh.tacocloud.domain.repository;

import com.hzh.tacocloud.domain.entity.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends MongoRepository<Ingredient, String> {

}
