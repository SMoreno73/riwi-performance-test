package com.performance.test.api.dto.response;

import java.util.List;

import com.performance.test.api.dto.response.basic.UserBasicResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse extends UserBasicResponse{

    private List<ReedemedVoucherResponse> reedemedVouchers;
}
