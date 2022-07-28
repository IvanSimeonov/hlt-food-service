package com.ivnsim.hltfoodservice.domains;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class FoodTableViewDTO {
    private Long id;

    private String brandName;

    private String description;

    private Long calories;

    private Long proteins;

    private Long totalCarbohydrates;

    private Long totalFats;
}
