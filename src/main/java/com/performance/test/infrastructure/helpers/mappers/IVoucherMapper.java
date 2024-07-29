package com.performance.test.infrastructure.helpers.mappers;

import com.performance.test.api.dto.response.VoucherResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.performance.test.api.dto.request.VoucherRequest;
import com.performance.test.api.dto.response.basic.VoucherBasicResponse;
import com.performance.test.domain.entities.Voucher;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IVoucherMapper {

    @Mapping(target = "id", ignore = true)
    Voucher toVoucher(VoucherRequest voucherRequest);

    VoucherResponse toVoucherResponse(Voucher voucher);

}
