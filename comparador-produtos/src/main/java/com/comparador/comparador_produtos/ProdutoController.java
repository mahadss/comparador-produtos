package com.comparador.comparador_produtos;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sistema/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<Produto> buscarProdutos(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) Double precoMin,
            @RequestParam(required = false) Double precoMax,
            @RequestParam(required = false) Double avaliacaoMin,
            @RequestParam(required = false) String ordenarPor) {

        List<Produto> resultado = new ArrayList<>(repository.findAll());

        if (nome != null && !nome.isBlank())
            resultado = resultado.stream()
                    .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
                    .collect(Collectors.toList());

        if (categoria != null && !categoria.isBlank())
            resultado = resultado.stream()
                    .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                    .collect(Collectors.toList());

        if (marca != null && !marca.isBlank())
            resultado = resultado.stream()
                    .filter(p -> p.getMarca().equalsIgnoreCase(marca))
                    .collect(Collectors.toList());

        if (precoMin != null)
            resultado = resultado.stream()
                    .filter(p -> p.getPreco() >= precoMin)
                    .collect(Collectors.toList());

        if (precoMax != null)
            resultado = resultado.stream()
                    .filter(p -> p.getPreco() <= precoMax)
                    .collect(Collectors.toList());

        if (avaliacaoMin != null)
            resultado = resultado.stream()
                    .filter(p -> p.getAvaliacao() >= avaliacaoMin)
                    .collect(Collectors.toList());

        if (ordenarPor != null) {
            switch (ordenarPor) {
                case "menorPreco" -> resultado.sort(Comparator.comparingDouble(Produto::getPreco));
                case "maiorPreco" -> resultado.sort(Comparator.comparingDouble(Produto::getPreco).reversed());
                case "nome" -> resultado.sort(Comparator.comparing(Produto::getNome));
                case "avaliacao" -> resultado.sort(Comparator.comparingDouble(Produto::getAvaliacao).reversed());
            }
        }

        return resultado;
    }
}