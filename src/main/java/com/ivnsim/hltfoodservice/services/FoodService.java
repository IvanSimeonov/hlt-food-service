package com.ivnsim.hltfoodservice.services;

import com.ivnsim.hltfoodservice.domains.FoodDTO;

import java.util.List;

public interface FoodService {

    void save(FoodDTO foodDTO);

    FoodDTO findById(Long id);

    List<FoodDTO> findAllFoods();

    void updateFoodById(Long id, FoodDTO foodDTO);

    void deleteFoodById(Long id);

    Long findTotalFoodsAmount();
}
