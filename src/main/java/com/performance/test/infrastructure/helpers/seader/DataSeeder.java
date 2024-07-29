package com.performance.test.infrastructure.helpers.seader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.performance.test.domain.entities.Product;
import com.performance.test.domain.repositories.ProductRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DataSeeder implements CommandLineRunner {
    
    private final ProductRepository productRepository;
    
    @Override
    public void run(String... args) throws Exception {
        
        if(this.productRepository.count() > 0) return;

        Product product1 = Product.builder().name("Milk").price(4500).build();
        Product product2 = Product.builder().name("Rice").price(2600).build();
        Product product3 = Product.builder().name("Suggar").price(4250).build();
        Product product4 = Product.builder().name("Beans").price(4900).build();
        Product product5 = Product.builder().name("Water").price(1200).build();
        Product product6 = Product.builder().name("Bread").price(900).build();
        Product product7 = Product.builder().name("Lentils").price(5500).build();
        Product product8 = Product.builder().name("Butter").price(7000).build();
        Product product9 = Product.builder().name("yogurt").price(2000).build();
        Product product10 = Product.builder().name("Cheese").price(8300).build();

        this.productRepository.save(product1);
        this.productRepository.save(product2);
        this.productRepository.save(product3);
        this.productRepository.save(product4);
        this.productRepository.save(product5);
        this.productRepository.save(product6);
        this.productRepository.save(product7);
        this.productRepository.save(product8);
        this.productRepository.save(product9);
        this.productRepository.save(product10);


    }

}

