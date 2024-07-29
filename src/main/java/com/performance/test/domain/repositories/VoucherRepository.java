package com.performance.test.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.performance.test.domain.entities.Voucher;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long>{
    
}
