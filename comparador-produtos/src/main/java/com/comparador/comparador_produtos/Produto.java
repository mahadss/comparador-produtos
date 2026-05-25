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
    private double preco;
    private double avaliacao;
    private String imagem;

    public Produto() {}

    public Produto(int id, String nome, String categoria, String marca, double preco, double avaliacao, String imagem) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.marca = marca;
        this.preco = preco;
        this.avaliacao = avaliacao;
        this.imagem = imagem;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public String getMarca() { return marca; }
    public double getPreco() { return preco; }
    public double getAvaliacao() { return avaliacao; }
    public String getImagem() { return imagem; }
}