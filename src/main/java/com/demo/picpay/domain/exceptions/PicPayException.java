package com.demo.picpay.domain.exceptions;

public class PicPayException extends RuntimeException {
    public PicPayException(String msg) {
        super(msg);
    }

    public PicPayException(String message, Throwable cause) {
        super(message, cause);
    }
}
