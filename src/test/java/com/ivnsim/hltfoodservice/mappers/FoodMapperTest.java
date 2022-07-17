package com.ivnsim.hltfoodservice.mappers;

import com.ivnsim.hltfoodservice.domains.FoodDTO;
import com.ivnsim.hltfoodservice.models.Food;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoodMapperTest {

    private final EasyRandomParameters parameters = new EasyRandomParameters();
    private final EasyRandom generator = new EasyRandom(parameters);
    private Food food;
    private FoodDTO foodDTO;


    @BeforeEach
    public void setUp() {
        parameters.stringLengthRange(3, 8);

    }

    @DisplayName("Should_Succeed_When_FoodToFoodDTO")
    @Test
    void foodToFoodDTO() {

        //Given
        food = generator.nextObject(Food.class);

        //When
        foodDTO = FoodMapper.INSTANCE.foodToFoodDTO(food);

        //Then
        assertEquals(food.getId(), foodDTO.getId());
        assertEquals(food.getVersion(), foodDTO.getVersion());
        assertEquals(food.getCreatedDate(), foodDTO.getCreatedDate());
        assertEquals(food.getLastModifiedDate(), foodDTO.getLastModifiedDate());
        assertEquals(food.getBrandName(), foodDTO.getBrandName());
        assertEquals(food.getDescription(), foodDTO.getDescription());
        assertEquals(food.getCalories(), foodDTO.getCalories());
        assertEquals(food.getProteins(), foodDTO.getProteins());
        assertEquals(food.getTotalCarbohydrates(), foodDTO.getTotalCarbohydrates());
        assertEquals(food.getFibers(), foodDTO.getFibers());
        assertEquals(food.getSugars(), foodDTO.getSugars());
        assertEquals(food.getTotalFats(), foodDTO.getTotalFats());
        assertEquals(food.getSaturatedFats(), foodDTO.getSaturatedFats());
        assertEquals(food.getPolyUnsaturatedFats(), foodDTO.getPolyUnsaturatedFats());
        assertEquals(food.getMonoUnsaturatedFats(), foodDTO.getMonoUnsaturatedFats());
        assertEquals(food.getTransFats(), foodDTO.getTransFats());
        assertEquals(food.getCholesterol(), foodDTO.getCholesterol());
        assertEquals(food.getSodium(), foodDTO.getSodium());
        assertEquals(food.getPotassium(), foodDTO.getPotassium());
        assertEquals(food.getCalcium(), foodDTO.getCalcium());
        assertEquals(food.getIron(), foodDTO.getIron());
        assertEquals(food.getVitaminA(), foodDTO.getVitaminA());
        assertEquals(food.getVitaminB1(), foodDTO.getVitaminB1());
        assertEquals(food.getVitaminB2(), foodDTO.getVitaminB2());
        assertEquals(food.getVitaminB3(), foodDTO.getVitaminB3());
        assertEquals(food.getVitaminB5(), foodDTO.getVitaminB5());
        assertEquals(food.getVitaminB6(), foodDTO.getVitaminB6());
        assertEquals(food.getVitaminB7(), foodDTO.getVitaminB7());
        assertEquals(food.getVitaminB9(), foodDTO.getVitaminB9());
        assertEquals(food.getVitaminB12(), foodDTO.getVitaminB12());
        assertEquals(food.getVitaminC(), foodDTO.getVitaminC());
        assertEquals(food.getVitaminD(), foodDTO.getVitaminD());
        assertEquals(food.getVitaminE(), foodDTO.getVitaminE());
        assertEquals(food.getVitaminK(), foodDTO.getVitaminK());
        assertEquals(food.getOmega3(), foodDTO.getOmega3());
        assertEquals(food.getOmega6(), foodDTO.getOmega6());
        assertEquals(food.getOmega9(), foodDTO.getOmega9());


    }

    @DisplayName("Should_Succeed_When_FoodDTOToFood")
    @Test
    void foodDTOtoFood() {

        //Given
        foodDTO = generator.nextObject(FoodDTO.class);

        //When
        food = FoodMapper.INSTANCE.foodDTOtoFood(foodDTO);

        //Then
        assertEquals(foodDTO.getId(), food.getId());
        assertEquals(foodDTO.getVersion(), food.getVersion());
        assertEquals(foodDTO.getCreatedDate(), food.getCreatedDate());
        assertEquals(foodDTO.getLastModifiedDate(), food.getLastModifiedDate());
        assertEquals(foodDTO.getBrandName(), food.getBrandName());
        assertEquals(foodDTO.getDescription(), food.getDescription());
        assertEquals(foodDTO.getCalories(), food.getCalories());
        assertEquals(foodDTO.getProteins(), food.getProteins());
        assertEquals(foodDTO.getTotalCarbohydrates(), food.getTotalCarbohydrates());
        assertEquals(foodDTO.getFibers(), food.getFibers());
        assertEquals(foodDTO.getSugars(), food.getSugars());
        assertEquals(foodDTO.getTotalFats(), food.getTotalFats());
        assertEquals(foodDTO.getSaturatedFats(), food.getSaturatedFats());
        assertEquals(foodDTO.getPolyUnsaturatedFats(), food.getPolyUnsaturatedFats());
        assertEquals(foodDTO.getMonoUnsaturatedFats(), food.getMonoUnsaturatedFats());
        assertEquals(foodDTO.getTransFats(), food.getTransFats());
        assertEquals(foodDTO.getCholesterol(), food.getCholesterol());
        assertEquals(foodDTO.getSodium(), food.getSodium());
        assertEquals(foodDTO.getPotassium(), food.getPotassium());
        assertEquals(foodDTO.getCalcium(), food.getCalcium());
        assertEquals(foodDTO.getIron(), food.getIron());
        assertEquals(foodDTO.getVitaminA(), food.getVitaminA());
        assertEquals(foodDTO.getVitaminB1(), food.getVitaminB1());
        assertEquals(foodDTO.getVitaminB2(), food.getVitaminB2());
        assertEquals(foodDTO.getVitaminB3(), food.getVitaminB3());
        assertEquals(foodDTO.getVitaminB5(), food.getVitaminB5());
        assertEquals(foodDTO.getVitaminB6(), food.getVitaminB6());
        assertEquals(foodDTO.getVitaminB7(), food.getVitaminB7());
        assertEquals(foodDTO.getVitaminB9(), food.getVitaminB9());
        assertEquals(foodDTO.getVitaminB12(), food.getVitaminB12());
        assertEquals(foodDTO.getVitaminC(), food.getVitaminC());
        assertEquals(foodDTO.getVitaminD(), food.getVitaminD());
        assertEquals(foodDTO.getVitaminE(), food.getVitaminE());
        assertEquals(foodDTO.getVitaminK(), food.getVitaminK());
        assertEquals(foodDTO.getOmega3(), food.getOmega3());
        assertEquals(foodDTO.getOmega6(), food.getOmega6());
        assertEquals(foodDTO.getOmega9(), food.getOmega9());
    }
}