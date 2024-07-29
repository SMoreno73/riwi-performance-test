package com.performance.test.infrastructure.services;

import com.performance.test.api.dto.request.VoucherRequest;
import com.performance.test.api.dto.response.VoucherResponse;
import com.performance.test.domain.entities.Voucher;
import com.performance.test.domain.repositories.VoucherRepository;
import com.performance.test.infrastructure.abstract_services.IVoucherService;
import com.performance.test.infrastructure.helpers.mappers.IVoucherMapper;
import com.performance.test.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VoucherService implements IVoucherService {

    @Autowired
    private final VoucherRepository voucherRepository;

    @Autowired
    private final IVoucherMapper voucherMapper;

    @Override
    public VoucherResponse create(VoucherRequest voucherRequest) {
        Voucher voucher = voucherMapper.toVoucher(voucherRequest);
        return voucherMapper.toVoucherResponse(voucherRepository.save(voucher));
    }

    @Override
    public void delete(Long aLong) {
        voucherRepository.deleteById(aLong);
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
        voucherMapper.updateFromVoucherRequest(voucherRequest, existingVoucher);
        return voucherMapper.toVoucherResponse(voucherRepository.save(existingVoucher));
    }

    @Override
    public Voucher getVoucherById(Long id) {
        return voucherRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("VOUCHER", id));
    }

}
