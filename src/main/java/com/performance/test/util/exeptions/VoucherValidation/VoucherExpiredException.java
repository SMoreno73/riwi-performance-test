package com.performance.test.util.exeptions.VoucherValidation;

public class VoucherExpiredException extends RuntimeException  {
    public VoucherExpiredException(String message) {
        super(message);
    }
}
