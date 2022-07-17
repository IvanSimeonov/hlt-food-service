package com.ivnsim.hltfoodservice.services;

import com.ivnsim.hltfoodservice.domains.FoodDTO;

public interface FoodService {

    FoodDTO findById(Long id);

    void save(FoodDTO foodDTO);
}
