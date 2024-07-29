package com.performance.test.infrastructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import com.performance.test.api.dto.request.ReedemVoucherRequest;
import com.performance.test.api.dto.response.ReedemedVoucherResponse;
import com.performance.test.domain.entities.Product;
import com.performance.test.domain.entities.ReedemedVoucher;
import com.performance.test.domain.entities.User;
import com.performance.test.domain.entities.Voucher;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IRedeemedVouchersMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "userId", target = "userId.id"),
            @Mapping(source = "voucherId", target = "voucherId.id"),
            @Mapping(source = "productId", target = "productId.id"),
    })
    ReedemedVoucher toReedemedVoucher(ReedemVoucherRequest reedemedVoucherRequest);

    ReedemedVoucherResponse toReedemedVoucherResponse(ReedemedVoucher reedemedVoucher);

}


