package com.ivnsim.hltfoodservice.services;

import com.ivnsim.hltfoodservice.commons.ExceptionDescriptions;
import com.ivnsim.hltfoodservice.domains.FoodDTO;
import com.ivnsim.hltfoodservice.domains.FoodPageDTO;
import com.ivnsim.hltfoodservice.exceptions.FoodNotFoundException;
import com.ivnsim.hltfoodservice.mappers.FoodMapper;
import com.ivnsim.hltfoodservice.models.Food;
import com.ivnsim.hltfoodservice.repositories.FoodRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public void save(FoodDTO foodDTO) {
        if (foodDTO != null) {
            this.foodRepository.save(FoodMapper.INSTANCE.foodDTOtoFood(foodDTO));
        }
    }

    @Override
    public void saveAll(List<FoodDTO> foodList) {
        if (foodList != null) {
            this.foodRepository.saveAll(
                    foodList.stream().map(FoodMapper.INSTANCE::foodDTOtoFood).collect(Collectors.toList())
            );
        }
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
    public List<FoodDTO> findAllFoods() {
        return this.foodRepository.findAll()
                .stream()
                .map(FoodMapper.INSTANCE::foodToFoodDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FoodPageDTO findFoodPage(Integer pageNumber, Integer pageSize, String sortBy, String searchWord) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, sortBy));
        return FoodMapper.INSTANCE.pageToPageDTO(this.foodRepository.findFoodsPage(searchWord, pageable));

    }

    @Override
    public void updateFoodById(Long id, FoodDTO foodDTO) {
        Optional<Food> food = this.foodRepository.findById(id);
        if (foodDTO != null && food.isPresent()) {
            this.foodRepository.save(FoodMapper.INSTANCE.updateFoodFromFoodDTO(foodDTO, food.get()));
        }
    }

    @Override
    public void deleteFoodById(Long id) {
        this.foodRepository.deleteById(id);
    }

    @Override
    public Long findTotalFoodsAmount() {
        return this.foodRepository.count();
    }
}
