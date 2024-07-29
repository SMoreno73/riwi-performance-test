package com.performance.test.api.dto.response.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductBasicResponse {

    private Long id;
    private String name;
    private double price;
    
}
