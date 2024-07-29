package com.performance.test.infrastructure.abstract_services;

import com.performance.test.api.dto.request.ReedemVoucherRequest;
import com.performance.test.api.dto.request.VoucherRequest;
import com.performance.test.api.dto.response.ReedemedVoucherResponse;
import com.performance.test.api.dto.response.VoucherResponse;
import com.performance.test.domain.entities.ReedemedVoucher;
import com.performance.test.infrastructure.abstract_services.generic.CreateService;
import com.performance.test.infrastructure.abstract_services.generic.DeleteService;
import com.performance.test.infrastructure.abstract_services.generic.ReadAllService;
import com.performance.test.infrastructure.abstract_services.generic.ReadService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IReedemedVoucherService extends
        CreateService<ReedemVoucherRequest, ReedemedVoucherResponse>,
        ReadService<ReedemedVoucherResponse, Long>,
        ReadAllService<ReedemedVoucherResponse>,
        DeleteService<Long> {
    ReedemedVoucher getVoucherById(Long id);
    ReedemedVoucher getReedemedVoucherByVoucherId(Long voucherId);
}
