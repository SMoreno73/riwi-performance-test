package com.performance.test.infrastructure.services;

import com.performance.test.api.dto.request.ProductRequest;
import com.performance.test.api.dto.response.ProductResponse;
import com.performance.test.domain.entities.Product;
import com.performance.test.domain.repositories.ProductRepository;
import com.performance.test.infrastructure.abstract_services.IProductService;
import com.performance.test.infrastructure.helpers.mappers.IProductMapper;
import com.performance.test.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final IProductMapper productMapper;

    @Override
    public ProductResponse create(ProductRequest productRequest) {
        return this.productMapper.toProductResponse(this.productRepository.save(this.productMapper.toProduct(productRequest)));
    }

    @Override
    public void delete(Long id) {
        this.productRepository.delete(this.getProductById(id));
    }

    @Override
    public Page<ProductResponse> getAll(Pageable pageable) {
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage.map(productMapper::toProductResponse);
    }

    @Override
    public Optional<ProductResponse> getById(Long id) {
        return Optional.of(productMapper.toProductResponse(getProductById(id)));
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("PRODUCT", id));
    }
}
