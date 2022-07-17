package com.ivnsim.hltfoodservice.controllers;

import com.ivnsim.hltfoodservice.domains.FoodDTO;
import com.ivnsim.hltfoodservice.services.FoodService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }


    @GetMapping("/{id}")
    public FoodDTO findFoodById(@PathVariable("id") Long id) {
        return this.foodService.findById(id);
    }

    @PostMapping
    public void createFood(@RequestBody FoodDTO foodDTO) {
        this.foodService.save(foodDTO);
    }

}
