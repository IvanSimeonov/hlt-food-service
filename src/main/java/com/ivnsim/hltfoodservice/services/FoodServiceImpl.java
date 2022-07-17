package com.ivnsim.hltfoodservice.services;

import com.ivnsim.hltfoodservice.commons.ExceptionDescriptions;
import com.ivnsim.hltfoodservice.domains.FoodDTO;
import com.ivnsim.hltfoodservice.exceptions.FoodNotFoundException;
import com.ivnsim.hltfoodservice.mappers.FoodMapper;
import com.ivnsim.hltfoodservice.repositories.FoodRepository;
import org.springframework.stereotype.Service;


@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public FoodDTO findById(Long id) {
        return FoodMapper.INSTANCE.foodToFoodDTO(
                this.foodRepository.findById(id)
                        .orElseThrow(() -> new FoodNotFoundException(
                                String.format(ExceptionDescriptions.FOOD_WITH_ID_NOT_FOUND_EXCEPTION, id)
                        ))
        );
    }

    @Override
    public void save(FoodDTO foodDTO) {
        if (foodDTO != null) {
            this.foodRepository.save(FoodMapper.INSTANCE.foodDTOtoFood(foodDTO));
        }
    }
}
