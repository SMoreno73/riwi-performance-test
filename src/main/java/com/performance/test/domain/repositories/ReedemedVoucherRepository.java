package com.performance.test.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.performance.test.domain.entities.ReedemedVoucher;

@Repository
public interface ReedemedVoucherRepository extends JpaRepository<ReedemedVoucher, Long>{
    
}
