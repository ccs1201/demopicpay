package com.demo.picpay.controler.dto;

import com.demo.picpay.entities.TipoUsuario;
import com.demo.picpay.entities.Usuario;

import java.math.BigDecimal;

public record UsuarioDTO(
        String nomeCompleto,
        Integer cpf,
        String email,
        String senha,
        TipoUsuario tipoUsuario
) {

    public Usuario toUsuario() {

        Usuario usuario = new Usuario();

        usuario.setTipoUsuario(tipoUsuario);
        usuario.setCpf(cpf);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setNomeCompleto(nomeCompleto);
        usuario.setSaldo(BigDecimal.ZERO);

        return usuario;
    }
}
