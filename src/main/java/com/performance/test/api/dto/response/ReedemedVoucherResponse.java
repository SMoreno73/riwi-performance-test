package com.performance.test.api.dto.response;

import java.time.LocalDate;

import com.performance.test.domain.entities.Product;
import com.performance.test.domain.entities.User;
import com.performance.test.domain.entities.Voucher;
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

    private User userId;
    private Product productId;
    private Voucher voucherId;
    
}
