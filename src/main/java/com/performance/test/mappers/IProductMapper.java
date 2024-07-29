package com.performance.test.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.performance.test.api.dto.request.ProductRequest;
import com.performance.test.api.dto.response.basic.ProductBasicResponse;
import com.performance.test.domain.entities.Product;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reedemedVouchers", ignore = true)
    Product requestToEntity(ProductRequest request);

    ProductBasicResponse entityToResponse(Product entity);

}
