package com.demo.picpay.domain.repository;

import com.demo.picpay.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRespository extends JpaRepository<Transacao, Long> {
}
