package com.ivnsim.hltfoodservice.repositories;

import com.ivnsim.hltfoodservice.domains.FoodTableViewDTO;
import com.ivnsim.hltfoodservice.models.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    @Query("SELECT new com.ivnsim.hltfoodservice.domains.FoodTableViewDTO(f.id, f.brandName, f.description, f.calories, f.proteins, f.totalCarbohydrates, f.totalFats) " +
            "FROM Food f WHERE CONCAT(f.id, '') LIKE CONCAT('%', :searchWord, '%') " +
            "OR UPPER(f.brandName) LIKE UPPER(CONCAT('%', :searchWord, '%')) " +
            "OR UPPER(f.description) LIKE UPPER(CONCAT('%', :searchWord, '%')) " +
            "OR CONCAT(f.calories, '') LIKE UPPER(CONCAT('%', :searchWord, '%')) " +
            "OR CONCAT(f.proteins, '') LIKE UPPER(CONCAT('%', :searchWord, '%')) " +
            "OR CONCAT(f.totalCarbohydrates, '') LIKE UPPER(CONCAT('%', :searchWord, '%')) " +
            "OR CONCAT(f.totalFats, '') LIKE UPPER(CONCAT('%', :searchWord, '%'))")
    Page<FoodTableViewDTO> findFoodsPage(String searchWord, Pageable pageable);
}
