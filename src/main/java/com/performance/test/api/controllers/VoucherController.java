package com.performance.test.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.performance.test.api.dto.request.VoucherRequest;
import com.performance.test.api.dto.response.VoucherResponse;
import com.performance.test.api.dto.response.VoucherStatusResponse;
import com.performance.test.infrastructure.abstract_services.IVoucherService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping()
@AllArgsConstructor
public class VoucherController {

    @Autowired
    private final IVoucherService VoucherService;

    @PostMapping
    public ResponseEntity<VoucherResponse> saveVoucher(@Validated @RequestBody VoucherRequest VoucherRequest) {
        return ResponseEntity.ok(VoucherService.create(VoucherRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VoucherResponse> updateVoucher(
            @PathVariable Long id,
            @Validated @RequestBody VoucherRequest VoucherRequest
    ) {
        return ResponseEntity.ok(VoucherService.update(id, VoucherRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoucher(@PathVariable Long id) {
        VoucherService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<VoucherResponse>> getVoucher(@PathVariable Long id) {
        return ResponseEntity.ok(VoucherService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<VoucherResponse>> getAllVouchers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(VoucherService.getAll(pageable));
    }

    @GetMapping("/check-validity/{id}")
    public ResponseEntity<VoucherStatusResponse> checkVoucherValidity(@PathVariable Long id) {
        VoucherStatusResponse voucherStatus = VoucherService.checkVoucherValidity(id);
        return ResponseEntity.ok(voucherStatus);
    }
    
}
