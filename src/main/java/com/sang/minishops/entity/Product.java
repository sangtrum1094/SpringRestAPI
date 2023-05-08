package com.sang.minishops.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private String productDescription;
    private Double productDiscountedPrince;
    private Double productActualPrince;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="product_images",
               joinColumns = {
                   @JoinColumn(name="product_id")
               },
            inverseJoinColumns = {
                   @JoinColumn(name="image_id")
            }
    )
    private Set<ImageModel> productImage;
}
