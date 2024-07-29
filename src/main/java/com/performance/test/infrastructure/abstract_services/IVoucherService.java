package com.performance.test.infrastructure.abstract_services;

import com.performance.test.api.dto.request.VoucherRequest;
import com.performance.test.api.dto.response.VoucherResponse;
import com.performance.test.api.dto.response.VoucherStatusResponse;
import com.performance.test.domain.entities.Voucher;
import com.performance.test.infrastructure.abstract_services.generic.*;

public interface IVoucherService extends
        CreateService<VoucherRequest, VoucherResponse>,
        ReadService<VoucherResponse, Long>,
        ReadAllService<VoucherResponse>,
        DeleteService<Long>,
        UpdateService<VoucherRequest, VoucherResponse, Long> {
    Voucher getVoucherById(Long id);
    VoucherStatusResponse checkVoucherValidity(Long id);
}
