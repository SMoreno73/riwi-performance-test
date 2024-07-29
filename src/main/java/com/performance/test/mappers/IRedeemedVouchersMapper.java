package com.performance.test.mappers;

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
        @Mapping(source = "userId", target = "userId."),
        @Mapping(source = "voucherId", target = "voucherId", qualifiedByName = "longToEntityVoucher"),
        @Mapping(source = "productId", target = "productId", qualifiedByName = "longToEntityProduct"),
        @Mapping(target = "date", ignore = true),
        @Mapping(target = "finalPrice", ignore = true)
    })

    ReedemedVoucher requestToEntity(ReedemVoucherRequest request);

 
    ReedemedVoucherResponse entityToResponse(ReedemedVoucher entity);


    @Named("longToEntityUser")
    default User longToEntityUser(Long id){
        if (id == null) return null;
        User user = new User();
        user.setId(id);
        return user;
    }

    @Named("longToEntityVoucher")
    default Voucher longToEntityVoucher(Long id){
        if (id == null) return null;
        Voucher voucher = new Voucher();
        voucher.setId(id);
        return voucher;
    }

    @Named("longToEntityProduct")
    default Product longToEntityProduct(Long id){
        if (id == null) return null;
        Product product = new Product();
        product.setId(id);
        return product;
    }

    


}


