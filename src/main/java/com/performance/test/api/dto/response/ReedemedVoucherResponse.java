package com.performance.test.api.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReedemedVoucherResponse {

    private Long id;
    private LocalDate date;
    private double finalPrice;

    private Long userdId;
    private Long productId;
    private Long voucherId;
    
}
