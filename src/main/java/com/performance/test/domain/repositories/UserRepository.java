package com.performance.test.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.performance.test.domain.entities.ReedemedVoucher;
import com.performance.test.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query("select c from reedemed c WHERE c.user_id LIKE %:user%")
    List<ReedemedVoucher> getVoucherByUser(Long user);
}
