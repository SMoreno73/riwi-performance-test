package com.performance.test.infrastructure.abstract_services;

import java.util.List;

import com.performance.test.api.dto.request.VoucherRequest;
import com.performance.test.api.dto.response.VoucherResponse;
import com.performance.test.domain.entities.ReedemedVoucher;
import com.performance.test.infrastructure.abstract_services.generic.CreateService;
import com.performance.test.infrastructure.abstract_services.generic.DeleteService;
import com.performance.test.infrastructure.abstract_services.generic.ReadAllService;
import com.performance.test.infrastructure.abstract_services.generic.ReadService;

public interface IReedemedVoucherService extends
        CreateService<VoucherRequest, VoucherResponse>,
        ReadService<VoucherResponse, Long>,
        ReadAllService<VoucherResponse>,
        DeleteService<Long>
{
    ReedemedVoucher getVoucherById(Long id);
}
