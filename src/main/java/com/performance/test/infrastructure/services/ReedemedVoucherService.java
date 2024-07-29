package com.performance.test.infrastructure.services;

import com.performance.test.api.dto.request.VoucherRequest;
import com.performance.test.api.dto.response.VoucherResponse;
import com.performance.test.domain.entities.ReedemedVoucher;
import com.performance.test.domain.repositories.ReedemedVoucherRepository;
import com.performance.test.domain.repositories.UserRepository;
import com.performance.test.infrastructure.abstract_services.IReedemedVoucherService;
import com.performance.test.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReedemedVoucherService implements IReedemedVoucherService {

    @Autowired
    private final ReedemedVoucherRepository reedemedVoucherRepository;
    private final UserRepository userRepository;

    @Override
    public VoucherResponse create(VoucherRequest voucherRequest) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Page<VoucherResponse> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<VoucherResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public ReedemedVoucher getVoucherById(Long id) {
        return reedemedVoucherRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("VOUCHER", id));
    }
}
