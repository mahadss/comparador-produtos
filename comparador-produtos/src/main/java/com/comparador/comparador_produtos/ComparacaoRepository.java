package com.comparador.comparador_produtos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComparacaoRepository extends JpaRepository<Comparacao, Integer> {
}