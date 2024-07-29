package com.performance.test.api.dto.response.basic;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoucherBasicResponse {

    private Long id;
    private LocalDate expirationDate;
    private int discount;
    private boolean status;

}
