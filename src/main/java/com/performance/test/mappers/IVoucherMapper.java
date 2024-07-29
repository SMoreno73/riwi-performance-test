package com.performance.test.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.performance.test.api.dto.request.VoucherRequest;
import com.performance.test.api.dto.response.basic.VoucherBasicResponse;
import com.performance.test.domain.entities.Voucher;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IVoucherMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "reedemedVouchers", ignore = true)
    Voucher requestToEntity(VoucherRequest request);

    VoucherBasicResponse entityToResponse(Voucher entity);

}
