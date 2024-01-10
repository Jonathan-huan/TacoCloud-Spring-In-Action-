package com.hzh.tacocloud.domain.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

public record IngredientRef(Ingredient ingredient) {
}
