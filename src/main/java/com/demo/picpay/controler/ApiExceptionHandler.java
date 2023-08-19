package com.demo.picpay.controler;

import com.demo.picpay.controler.dto.ErrosResponse;
import com.demo.picpay.domain.exceptions.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @ExceptionHandler(PicPayException.class)
    public ResponseEntity<ErrosResponse> handlerPicPayException(PicPayException exception) {

        return ResponseEntity.badRequest()
                .body(new ErrosResponse(exception.getMessage(), HttpStatus.BAD_REQUEST));

    }
}
