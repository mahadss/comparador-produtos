package com.comparador.comparador_produtos;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sistema/comparacoes")
@CrossOrigin(origins = "*")

public class ComparacaoController {
    private List<Produto> comparacao = new ArrayList<>();

    @GetMapping
    public List<Produto> listarComparacao(){
        return comparacao;
    }

    @PostMapping
    public String incluirProduto(@RequestBody Produto produto){
       if (comparacao.size () == 3){
           return "Limite máximo de 3 produtos atingido!";
       }
       comparacao.add(produto);
       return "Produto adicionado á comparação com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String excluirProduto(@PathVariable int id){
        comparacao.removeIf(produto -> produto.getId() == id);
        return "Produto excluido da comparação!";

    }
}
