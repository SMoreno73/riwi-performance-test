package com.performance.test.api.dto.response;

import java.util.List;

import com.performance.test.api.dto.response.basic.ProductBasicResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse extends ProductBasicResponse {

    private List<ReedemedVoucherResponse> reedemedVouchers;
    
}
