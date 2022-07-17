package com.ivnsim.hltfoodservice.services;

import com.ivnsim.hltfoodservice.exceptions.FoodNotFoundException;
import com.ivnsim.hltfoodservice.models.Food;
import com.ivnsim.hltfoodservice.repositories.FoodRepository;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.ivnsim.hltfoodservice.commons.ExceptionDescriptions.FOOD_WITH_ID_NOT_FOUND_EXCEPTION;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FoodServiceImplTest {

    private static final Long FOOD_NON_EXISTING_ID = 2L;
    private final EasyRandomParameters parameters = new EasyRandomParameters();
    private final EasyRandom generator = new EasyRandom(parameters);
    @Mock
    private FoodRepository foodRepository;

    private FoodServiceImpl foodService;


    private Food food;

    @BeforeEach
    public void setUp() {
        food = generator.nextObject(Food.class);
        parameters.stringLengthRange(3, 8);
        foodService = new FoodServiceImpl(foodRepository);
    }

    @DisplayName("Should_Succeed_When_FoodIdFoundInDB")
    @Test
    void findByIdSucceeds() {
        when(this.foodRepository.findById(anyLong())).thenReturn(Optional.of(this.food));
        assertNotNull(this.foodService.findById(this.food.getId()));
        assertEquals(this.food.getId(), this.foodService.findById(this.food.getId()).getId());
    }

    @DisplayName("Should_Throw_Exception_When_FoodIdNotFoundInDB")
    @Test
    void findByIdThrowsException() {
        Exception exception = null;
        when(this.foodRepository.findById(anyLong())).thenReturn(Optional.empty());
        try {
            this.foodService.findById(FOOD_NON_EXISTING_ID);
        } catch (FoodNotFoundException e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception.getMessage().contains(String.format(FOOD_WITH_ID_NOT_FOUND_EXCEPTION, FOOD_NON_EXISTING_ID)));
    }


}