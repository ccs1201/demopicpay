package com.demo.picpay.domain.service;

import com.demo.picpay.domain.exceptions.PicPayException;
import com.demo.picpay.domain.repository.TransacaoRespository;
import com.demo.picpay.entities.TipoUsuario;
import com.demo.picpay.entities.Usuario;
import com.demo.picpay.entities.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TransacaoRespository respository;


    @Transactional
    public String transferir(Long pagadorId, Long recebedorId, BigDecimal valor) {

        Usuario pagador = usuarioService.findById(pagadorId);

        this.validarTipoUsuario(pagador);

        Usuario recebedor = usuarioService.findById(recebedorId);

        Transacao transacao = new Transacao();

        transacao.setPagador(pagador);
        transacao.setRecebedor(recebedor);
        transacao.setValor(valor);

        usuarioService.sacar(pagadorId, valor);
        usuarioService.depositar(recebedorId, valor);

        respository.save(transacao);

        return pagador.getNomeCompleto() + " enviou R$" + valor + " para " + recebedor.getNomeCompleto();
    }


    private void validarTipoUsuario(Usuario usuario) {

        if (usuario.getTipoUsuario().equals(TipoUsuario.LOJISTA)) {
            throw new PicPayException("Varejistas não podem efetuar transferências");
        }
    }

    public List<Transacao> findAll() {

        return respository.findAll();
    }
}
