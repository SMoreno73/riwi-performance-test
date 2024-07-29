package com.performance.test.infrastructure.helpers.mappers;

import com.performance.test.api.dto.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.performance.test.api.dto.request.ProductRequest;
import com.performance.test.api.dto.response.basic.ProductBasicResponse;
import com.performance.test.domain.entities.Product;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IProductMapper {

    @Mapping(target = "id", ignore = true)
    Product toProduct(ProductRequest productRequest);

    ProductResponse toProductResponse(Product product);

}
