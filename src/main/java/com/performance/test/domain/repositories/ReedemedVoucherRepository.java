package com.performance.test.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.performance.test.domain.entities.ReedemedVoucher;

@Repository
public interface ReedemedVoucherRepository extends JpaRepository<ReedemedVoucher, Long>{
    @Query("SELECT rv FROM reedemed rv WHERE rv.voucherId.id = :voucherId")
    ReedemedVoucher getReedemedVoucherByVoucherId(@Param("voucherId") Long voucherId);
}
