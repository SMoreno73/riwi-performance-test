package com.performance.test.api.dto.response;

import com.performance.test.domain.entities.Voucher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoucherStatusResponse {

    private Voucher voucher;
    private String message;
}