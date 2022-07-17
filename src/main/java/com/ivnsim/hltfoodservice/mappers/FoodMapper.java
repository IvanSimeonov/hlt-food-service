package com.ivnsim.hltfoodservice.mappers;

import com.ivnsim.hltfoodservice.domains.FoodDTO;
import com.ivnsim.hltfoodservice.models.Food;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodMapper {

    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    FoodDTO foodToFoodDTO(Food food);

    Food foodDTOtoFood(FoodDTO foodDTO);

}
