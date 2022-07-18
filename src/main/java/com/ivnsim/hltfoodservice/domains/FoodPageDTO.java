package com.ivnsim.hltfoodservice.domains;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class FoodPageDTO {
    private List<FoodTableViewDTO> foods;
    private Integer pageNumber;
    private Integer totalPages;
    private Long totalFoods;
}
