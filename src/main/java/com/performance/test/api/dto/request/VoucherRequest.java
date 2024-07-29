package com.performance.test.api.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoucherRequest {

    @NotNull(message = "expiration date of this voucher is required")
    private LocalDate expirationDate;

    @NotNull(message = "discount of this voucher is required")
    private int discount;
    
}
