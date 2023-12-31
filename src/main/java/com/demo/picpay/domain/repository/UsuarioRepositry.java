package com.demo.picpay.domain.repository;

import com.demo.picpay.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositry extends JpaRepository<Usuario, Long> {
}
