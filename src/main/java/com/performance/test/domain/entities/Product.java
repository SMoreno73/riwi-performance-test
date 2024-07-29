package com.performance.test.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 80, nullable = false )
    private String name;
    @Column(nullable = false)
    private double price;

    @OneToMany(
        fetch = FetchType.EAGER,
        mappedBy = "productId",
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )
    private List<ReedemedVoucher> reedemedVouchers;
}
