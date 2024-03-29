package com.ivnsim.hltfoodservice.controllers;

import com.ivnsim.hltfoodservice.domains.FoodDTO;
import com.ivnsim.hltfoodservice.domains.FoodPageDTO;
import com.ivnsim.hltfoodservice.services.FoodService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/foods")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @Operation(summary = "Add new food")
    @PostMapping("/create")
    public ResponseEntity<Void> createFood(@RequestBody FoodDTO foodDTO) {
        log.warn("Food " + foodDTO);
        this.foodService.save(foodDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(foodDTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Add all new foods")
    @PostMapping("/all")
    public void createFoods(@RequestBody List<FoodDTO> foodDTO) {
        this.foodService.saveAll(foodDTO);
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

    @Operation(summary = "Retrieve all existing foods in pages and sorted by specified field")
    @GetMapping("/pages")
    public FoodPageDTO findAllFoods(
            @RequestParam(defaultValue = "0", name = "pageNumber") Integer pageNumber,
            @RequestParam(defaultValue = "10", name = "pageSize") Integer pageSize,
            @RequestParam(defaultValue = "id", name = "sortBy") String sortBy,
            @RequestParam(defaultValue = "", name = "searchWord") String searchWord) {
        log.warn("Page Number: " + pageNumber );
        log.warn("Page Size: " + pageSize );
        log.warn("Sort By: " + sortBy );
        log.warn("Search Word: " + searchWord );
        return this.foodService.findFoodPage(pageNumber, pageSize, sortBy, searchWord);
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
