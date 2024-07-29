package com.performance.test.util.exeptions.VoucherValidation;

public class VoucherInactiveException extends RuntimeException{
    public VoucherInactiveException(String message) {
        super(message);
    }
}
