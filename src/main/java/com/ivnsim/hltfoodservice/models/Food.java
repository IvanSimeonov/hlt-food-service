package com.ivnsim.hltfoodservice.models;

import com.ivnsim.hltfoodservice.commons.TableAndColumnNames;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TableAndColumnNames.TABLE_FOOD)
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Version
    private Long version;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp lastModifiedDate;

    @NotNull
    private String brandName;

    @NotNull
    private String description;

    @NotNull
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
