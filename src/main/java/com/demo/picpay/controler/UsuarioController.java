package com.demo.picpay.controler;

import com.demo.picpay.controler.dto.UsuarioDTO;
import com.demo.picpay.domain.service.UsuarioService;
import com.demo.picpay.entities.Usuario;
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
@RequestMapping("/usuarios")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Usuario save(@RequestBody UsuarioDTO usuario) {
        Usuario u = usuarioService.save(usuario.toUsuario());
        return u;
    }

    @GetMapping
    public List<Usuario> getAll(){
        return usuarioService.findAll();
    }
}
