package com.demo.picpay.controler;

import com.demo.picpay.controler.dto.TransacaoDTO;
import com.demo.picpay.domain.service.TransacaoService;
import com.demo.picpay.entities.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String tranferir(@RequestBody TransacaoDTO dto) {

        return service.transferir(dto.pagadorId(), dto.recebedorId(), dto.valor());
    }

    @GetMapping
    public List<Transacao> getAll() {
        return service.findAll();
    }
}
