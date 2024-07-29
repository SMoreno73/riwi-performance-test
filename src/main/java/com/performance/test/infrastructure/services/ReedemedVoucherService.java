package com.performance.test.infrastructure.services;

import com.performance.test.api.dto.request.ReedemVoucherRequest;
import com.performance.test.api.dto.response.ReedemedVoucherResponse;
import com.performance.test.domain.entities.ReedemedVoucher;
import com.performance.test.domain.repositories.ReedemedVoucherRepository;
import com.performance.test.infrastructure.abstract_services.IReedemedVoucherService;
import com.performance.test.infrastructure.helpers.mappers.IRedeemedVouchersMapper;
import com.performance.test.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ReedemedVoucherService implements IReedemedVoucherService {

    @Autowired
    private final ReedemedVoucherRepository reedemedVoucherRepository;

    @Autowired
    private final IRedeemedVouchersMapper redeemedVoucherMapper;

    @Override
    public void delete(Long aLong) {
        reedemedVoucherRepository.deleteById(aLong);
    }

    @Override
    public ReedemedVoucherResponse create(ReedemVoucherRequest reedemVoucherRequest) {
        ReedemedVoucher reedemedVoucher = redeemedVoucherMapper.toReedemedVoucher(reedemVoucherRequest);
        return redeemedVoucherMapper.toReedemedVoucherResponse(reedemedVoucherRepository.save(reedemedVoucher));
    }

    @Override
    public Page<ReedemedVoucherResponse> getAll(Pageable pageable) {
        Page<ReedemedVoucher> reedemedVouchers = reedemedVoucherRepository.findAll(pageable);
        return reedemedVouchers.map(redeemedVoucherMapper::toReedemedVoucherResponse);
    }

    @Override
    public Optional<ReedemedVoucherResponse> getById(Long aLong) {
        return Optional.of(redeemedVoucherMapper.toReedemedVoucherResponse(getVoucherById(aLong)));
    }

    @Override
    public ReedemedVoucher getVoucherById(Long id) {
        return reedemedVoucherRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("REEDEMED_VOUCHER", id));
    }
}
