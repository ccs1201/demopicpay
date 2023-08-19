package com.demo.picpay.domain.service;

import com.demo.picpay.domain.exceptions.PicPayException;
import com.demo.picpay.domain.repository.UsuarioRepositry;
import com.demo.picpay.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositry repositry;

    public Usuario save(Usuario usuario) {

        try {
            return repositry.save(usuario);
        } catch (DataIntegrityViolationException excecaoOriginal) {
            throw new PicPayException("E-mail ou CPf ja cadastrado.", excecaoOriginal);
        }
    }

    public BigDecimal depositar(Long recebedorId, BigDecimal valor) {

        if (valor.compareTo(BigDecimal.ZERO) > 0) {

            Usuario usuario = this.findById(recebedorId);

            this.atualizarSaldo(usuario, valor);

            return usuario.getSaldo();

        } else {
            throw new PicPayException("Deposito no valor de " + valor + " não é permitido, valores depositiados de vem ser maior que ZERO.");
        }
    }

    private void atualizarSaldo(Usuario usuario, BigDecimal valor) {

        BigDecimal saldoAutalizado = usuario.getSaldo().add(valor);
        usuario.setSaldo(saldoAutalizado);
        this.save(usuario);
    }

    public Usuario findById(Long id) {
        return repositry.findById(id)
                .orElseThrow(() -> new PicPayException("Usuário ID: " + id + " não encontrado."));
    }

    public void sacar(Long usuarioId, BigDecimal valor) {

        Usuario usuario = this.findById(usuarioId);

        if (usuario.getSaldo().compareTo(valor) < 0) {
            throw new PicPayException("Saldo insuficiente!");
        } else {
            usuario.setSaldo(usuario.getSaldo().subtract(valor));
        }

        this.save(usuario);
    }

    public List<Usuario> findAll() {
        return repositry.findAll();
    }
}
