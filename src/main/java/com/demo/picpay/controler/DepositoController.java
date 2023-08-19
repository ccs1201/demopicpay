package com.demo.picpay.controler;

import com.demo.picpay.controler.dto.Deposito;
import com.demo.picpay.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/usuarios/depositos")
public class DepositoController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal depositar(@RequestBody Deposito deposito) {
        return usuarioService.depositar(deposito.id(), deposito.valor());
    }
}
