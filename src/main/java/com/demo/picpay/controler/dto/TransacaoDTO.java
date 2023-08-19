package com.demo.picpay.controler;

import java.math.BigDecimal;

public record TransacaoDTO(Long pagadorId, Long recebedorId, BigDecimal valor) {
}
