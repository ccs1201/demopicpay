package com.demo.picpay.controler.dto;

import org.springframework.http.HttpStatus;

public record ErrosResponse(String mensagem, HttpStatus httpStatus, String detail) {
}
