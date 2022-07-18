package com.ivnsim.hltfoodservice.services;

import com.ivnsim.hltfoodservice.domains.FoodDTO;
import com.ivnsim.hltfoodservice.domains.FoodPageDTO;

import java.util.List;

public interface FoodService {

    void save(FoodDTO foodDTO);

    void saveAll(List<FoodDTO> foodList);

    FoodDTO findById(Long id);

    List<FoodDTO> findAllFoods();

    FoodPageDTO findFoodPage(Integer pageNumber, Integer pageSize, String sortBy, String searchWord);

    void updateFoodById(Long id, FoodDTO foodDTO);

    void deleteFoodById(Long id);

    Long findTotalFoodsAmount();
}
