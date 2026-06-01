package com.comparador.comparador_produtos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ComparacaoProdutoRepository extends JpaRepository<ComparacaoProduto, Integer> {
    List<ComparacaoProduto> findByComparacaoId(int comparacaoId);
}
