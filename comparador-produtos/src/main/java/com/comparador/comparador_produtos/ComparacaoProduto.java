package com.comparador.comparador_produtos;

import jakarta.persistence.*;

@Entity
@Table(name = "comparacao_produto")
public class ComparacaoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int comparacaoId;
    private int produtoId;

    public ComparacaoProduto() {}

    public int getId() { return id; }
    public int getComparacaoId() { return comparacaoId; }
    public int getProdutoId() { return produtoId; }
    public void setComparacaoId(int comparacaoId) { this.comparacaoId = comparacaoId; }
    public void setProdutoId(int produtoId) { this.produtoId = produtoId; }
}