package com.ivnsim.hltfoodservice.controllers;

import com.ivnsim.hltfoodservice.domains.FoodDTO;
import com.ivnsim.hltfoodservice.services.FoodService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @Operation(summary = "Add new food")
    @PostMapping
    public ResponseEntity<Void> createFood(@RequestBody FoodDTO foodDTO) {
        this.foodService.save(foodDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(foodDTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Retrieve a food by its id")
    @GetMapping("/{id}")
    public FoodDTO findFoodById(@PathVariable("id") Long id) {
        return this.foodService.findById(id);
    }

    @Operation(summary = "Retrieve all foods")
    @GetMapping
    public List<FoodDTO> findAllFoods() {
        return this.foodService.findAllFoods();
    }

    @Operation(summary = "Update an existing food")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateFoodById(@RequestBody FoodDTO foodDTO, @PathVariable("id") Long id) {
        this.foodService.updateFoodById(id, foodDTO);
    }

    @Operation(summary = "Delete a food by its id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFoodById(@PathVariable("id") Long id) {
        this.foodService.deleteFoodById(id);
    }

    @Operation(summary = "Retrieve the total amount of foods")
    @GetMapping("/total")
    public Long findTotalFoodsAmount() {
        return this.foodService.findTotalFoodsAmount();
    }
}
