package com.performance.test.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.performance.test.api.dto.request.ProductRequest;
import com.performance.test.api.dto.response.ProductResponse;
import com.performance.test.api.dto.response.basic.ProductBasicResponse;
import com.performance.test.infrastructure.abstract_services.IProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Tag(name = "Products")
public class ProductController {

    @Autowired
    private final IProductService productService;

    @Operation(summary = "create a product", description = "to create a product, info must be in json")
    @PostMapping
    public ResponseEntity<ProductBasicResponse> create(@Validated @RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productService.create(productRequest));
    }

    @Operation(summary = "Delete a Product")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get All prodcuts", description = "to get all products you need provide page and size")
    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAll(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size) {
            Pageable pageable = PageRequest.of(page, size);
            if (page != 0)
                pageable = PageRequest.of(page - 1, size);
            return ResponseEntity.ok(productService.getAll(pageable));
        }
    
    @Operation(summary = "Get an Specific product", description = "to get the product you need provide the ID")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductResponse>> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }
}
