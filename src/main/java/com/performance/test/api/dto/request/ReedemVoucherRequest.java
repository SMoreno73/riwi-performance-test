package com.performance.test.api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReedemVoucherRequest {

    @NotNull(message = "user ID must not be null")
    private long userId;

    @NotNull(message = "product ID must not be null")
    private long productId;

    @NotNull(message = "voucher ID must not be null")
    private long voucherId;
    
}
