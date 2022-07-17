package com.ivnsim.hltfoodservice.domains;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class FoodDTO {

    private Long id;

    private Long version;

    private Timestamp createdDate;

    private Timestamp lastModifiedDate;

    private String brandName;

    private String description;

    private Long calories;

    private Long proteins;

    private Long totalCarbohydrates;

    private Long fibers;

    private Long sugars;

    private Long totalFats;

    private Long saturatedFats;

    private Long polyUnsaturatedFats;

    private Long monoUnsaturatedFats;

    private Long transFats;

    private Long cholesterol;

    private Long sodium;

    private Long potassium;

    private Long calcium;

    private Long iron;

    private Long vitaminA;

    private Long vitaminB1;

    private Long vitaminB2;

    private Long vitaminB3;

    private Long vitaminB5;

    private Long vitaminB6;

    private Long vitaminB7;

    private Long vitaminB9;

    private Long vitaminB12;

    private Long vitaminC;

    private Long vitaminD;

    private Long vitaminE;

    private Long vitaminK;

    private Long omega3;

    private Long omega6;

    private Long omega9;
}
