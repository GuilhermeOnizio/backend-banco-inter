package com.guilhermeonizio.backend_banco_inter.repository;

import com.guilhermeonizio.backend_banco_inter.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
