package com.performance.test.infrastructure.abstract_services;

import com.performance.test.api.dto.request.ProductRequest;
import com.performance.test.api.dto.response.ProductResponse;
import com.performance.test.domain.entities.Product;
import com.performance.test.infrastructure.abstract_services.generic.CreateService;
import com.performance.test.infrastructure.abstract_services.generic.DeleteService;
import com.performance.test.infrastructure.abstract_services.generic.ReadAllService;
import com.performance.test.infrastructure.abstract_services.generic.ReadService;

public interface IProductService extends
        CreateService<ProductRequest, ProductResponse>,
        ReadService<ProductResponse, Long>,
        ReadAllService<ProductResponse>,
        DeleteService<Long>
{
    Product getProductById(Long id);
}
