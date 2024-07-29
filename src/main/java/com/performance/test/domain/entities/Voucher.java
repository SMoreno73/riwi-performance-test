package com.performance.test.domain.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "voucher")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate expirationDate;
    @Column(nullable = false)
    private int discount;
    @Column(nullable = false)
    private boolean status;

    @OneToMany(
        fetch = FetchType.EAGER,
        mappedBy = "voucherId",
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )
    private List<ReedemedVoucher> reedemedVouchers;
}
