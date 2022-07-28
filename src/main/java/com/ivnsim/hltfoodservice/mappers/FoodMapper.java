package com.ivnsim.hltfoodservice.mappers;

import com.ivnsim.hltfoodservice.domains.FoodDTO;
import com.ivnsim.hltfoodservice.domains.FoodPageDTO;
import com.ivnsim.hltfoodservice.domains.FoodTableViewDTO;
import com.ivnsim.hltfoodservice.models.Food;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface FoodMapper {

    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    FoodDTO foodToFoodDTO(Food food);

    Food foodDTOtoFood(FoodDTO foodDTO);

    @Mapping(target = "id", ignore = true)
    Food updateFoodFromFoodDTO(FoodDTO foodDTO, @MappingTarget Food food);

    default FoodPageDTO pageToPageDTO(Page<FoodTableViewDTO> foods) {
        if (foods == null) {
            return null;
        } else {
            FoodPageDTO foodPageDTO = new FoodPageDTO();
            foodPageDTO.setFoods(foods.getContent());
            foodPageDTO.setTotalPages(foods.getTotalPages());
            foodPageDTO.setPageNumber(foods.getNumber());
            foodPageDTO.setTotalFoods(foods.getTotalElements());
            return foodPageDTO;
        }
    };

}
