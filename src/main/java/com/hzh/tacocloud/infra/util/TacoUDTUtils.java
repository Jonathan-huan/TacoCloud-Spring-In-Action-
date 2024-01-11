package com.hzh.tacocloud.infra.util;

import com.hzh.tacocloud.domain.entity.Ingredient;
import com.hzh.tacocloud.domain.udt.IngredientUDT;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TacoUDTUtils {
    TacoUDTUtils INSTANCE = Mappers.getMapper(TacoUDTUtils.class);
    @Mapping(source = "name", target = "name")
    @Mapping(source = "type", target = "type")
    IngredientUDT toIngredientUDT(Ingredient ingredient);
}
