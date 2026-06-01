package com.comparador.comparador_produtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String categoria;
    private String marca;
    private String tela;
    private String armazenamento;
    private String bateria;
    private double preco;
    private double avaliacao;
    private String imagem;
    private boolean estoque;

    public Produto() {}

    public Produto(int id, String nome, String categoria, String marca, String tela, String armazenamento, String bateria, double preco, double avaliacao, String imagem, boolean estoque) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.marca = marca;
        this.tela = tela;
        this.armazenamento = armazenamento;
        this.bateria = bateria;
        this.preco = preco;
        this.avaliacao = avaliacao;
        this.imagem = imagem;
        this.estoque = estoque;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public String getMarca() { return marca; }
    public String getTela() { return tela; }
    public String getArmazenamento() { return armazenamento; }
    public String getBateria() { return bateria; }
    public double getPreco() { return preco; }
    public double getAvaliacao() { return avaliacao; }
    public String getImagem() { return imagem; }
    public boolean isEstoque() { return estoque; }
}