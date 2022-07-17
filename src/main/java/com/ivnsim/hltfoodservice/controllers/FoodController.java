package com.ivnsim.hltfoodservice.controllers;

import com.ivnsim.hltfoodservice.domains.FoodDTO;
import com.ivnsim.hltfoodservice.services.FoodService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }


    @Operation(summary = "Get a food by its id")
    @GetMapping("/{id}")
    public FoodDTO findFoodById(@PathVariable("id") Long id) {
        return this.foodService.findById(id);
    }

    @Operation(summary = "Add new food")
    @PostMapping
    public void createFood(@RequestBody FoodDTO foodDTO) {
        this.foodService.save(foodDTO);
    }

}
