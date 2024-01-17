package com.hzh.tacocloud.infra.converter;

import com.hzh.tacocloud.domain.entity.Ingredient;
import com.hzh.tacocloud.domain.repository.IngredientRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String,Ingredient> {

    private final IngredientRepository ingredientRepository;

    public IngredientByIdConverter(IngredientRepository ingredientRepository){
        this.ingredientRepository=ingredientRepository;
    }
    @Override
    public Ingredient convert(@NonNull String id) {
        return ingredientRepository.findById(id).orElse(null);
    }
}
