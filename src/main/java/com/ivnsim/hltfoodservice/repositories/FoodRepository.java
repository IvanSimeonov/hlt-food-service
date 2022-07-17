package com.ivnsim.hltfoodservice.repositories;

import com.ivnsim.hltfoodservice.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

}
