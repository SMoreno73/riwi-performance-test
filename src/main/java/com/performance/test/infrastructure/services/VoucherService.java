package com.performance.test.infrastructure.services;

import com.performance.test.api.dto.request.VoucherRequest;
import com.performance.test.api.dto.response.VoucherResponse;
import com.performance.test.api.dto.response.VoucherStatusResponse;
import com.performance.test.domain.entities.Voucher;
import com.performance.test.domain.repositories.VoucherRepository;
import com.performance.test.infrastructure.abstract_services.IReedemedVoucherService;
import com.performance.test.infrastructure.abstract_services.IVoucherService;
import com.performance.test.infrastructure.helpers.mappers.IVoucherMapper;
import com.performance.test.util.exeptions.IdNotFoundException;
import com.performance.test.util.exeptions.VoucherValidation.VoucherExpiredException;
import com.performance.test.util.exeptions.VoucherValidation.VoucherInactiveException;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VoucherService implements IVoucherService {

    @Autowired
    private final VoucherRepository voucherRepository;

    @Autowired
    private final IVoucherMapper voucherMapper;

    @Autowired
    private final IReedemedVoucherService reedemedVoucherService;

    @Override
    public VoucherResponse create(VoucherRequest voucherRequest) {
        Voucher voucher = voucherMapper.toVoucher(voucherRequest);
        return voucherMapper.toVoucherResponse(voucherRepository.save(voucher));
    }

    @Override
    public void delete(Long aLong) {
        if (reedemedVoucherService.getReedemedVoucherByVoucherId(aLong) == null) {
            voucherRepository.deleteById(aLong);
        } else
            throw new IdNotFoundException("VOUCHER IS IN USE", aLong);
    }

    @Override
    public Page<VoucherResponse> getAll(Pageable pageable) {
        Page<Voucher> vouchers = voucherRepository.findAll(pageable);
        return vouchers.map(voucherMapper::toVoucherResponse);
    }

    @Override
    public Optional<VoucherResponse> getById(Long aLong) {
        return Optional.of(voucherMapper.toVoucherResponse(getVoucherById(aLong)));
    }

    @Override
    public VoucherResponse update(Long aLong, VoucherRequest voucherRequest) {
        Voucher existingVoucher = getVoucherById(aLong);
        if (reedemedVoucherService.getReedemedVoucherByVoucherId(aLong) == null) {
            voucherMapper.updateFromVoucherRequest(voucherRequest, existingVoucher);
            return voucherMapper.toVoucherResponse(voucherRepository.save(existingVoucher));
        } else
            throw new IdNotFoundException("VOUCHER IS IN USE", aLong);
    }

    @Override
    public Voucher getVoucherById(Long id) {
        return voucherRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("VOUCHER", id));
    }

    @Override
    public VoucherStatusResponse checkVoucherValidity(Long id) {

        Voucher existingVoucher = getVoucherById(id);

        if (existingVoucher.getExpirationDate().isBefore(LocalDate.now())) {
            throw new VoucherExpiredException("Voucher has expired");
        } 
        if (!existingVoucher.isStatus()) {
            throw new VoucherInactiveException("Voucher is not active");
        }

        return new VoucherStatusResponse(existingVoucher, "Voucher is active and valid");

    }   
}
