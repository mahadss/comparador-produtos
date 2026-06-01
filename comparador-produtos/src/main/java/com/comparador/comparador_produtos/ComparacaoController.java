package com.comparador.comparador_produtos;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sistema/comparacoes")
@CrossOrigin(origins = "*")
public class ComparacaoController {

    @Autowired
    private ComparacaoRepository comparacaoRepository;

    @Autowired
    private ComparacaoProdutoRepository comparacaoProdutoRepository;

    @Autowired
    private ProdutoRepository repository;

    private List<Produto> comparacao = new ArrayList<>();

    @GetMapping
    public List<Produto> listarComparacao() {
        return comparacao;
    }

    @PostMapping
    public String incluirProduto(@RequestBody Produto produto) {
        if (comparacao.size() == 3) {
            return "Limite máximo de 3 produtos atingido!";
        }
        comparacao.add(produto);
        return "Produto adicionado à comparação com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String excluirProduto(@PathVariable int id) {
        comparacao.removeIf(produto -> produto.getId() == id);
        return "Produto excluído da comparação!";
    }

    @PostMapping("/salvar")
    public String salvarComparacao() {
        if (comparacao.isEmpty()) {
            return "Nenhum produto na comparação!";
        }
        Comparacao novaComparacao = new Comparacao();
        comparacaoRepository.save(novaComparacao);
        for (Produto p : comparacao) {
            ComparacaoProduto cp = new ComparacaoProduto();
            cp.setComparacaoId(novaComparacao.getId());
            cp.setProdutoId(p.getId());
            comparacaoProdutoRepository.save(cp);
        }
        return "Comparação salva no histórico!";
    }

    @GetMapping("/historico")
    public List<Comparacao> listarHistorico() {
        return comparacaoRepository.findAll();
    }

    @GetMapping("/historico/{id}/produtos")
    public List<Produto> listarProdutosDaComparacao(@PathVariable int id) {
        List<ComparacaoProduto> itens = comparacaoProdutoRepository.findByComparacaoId(id);
        List<Produto> produtos = new ArrayList<>();
        for (ComparacaoProduto cp : itens) {
            repository.findById(cp.getProdutoId()).ifPresent(produtos::add);
        }
        return produtos;
    }

    @DeleteMapping("/limpar")
    public String limparComparacao() {
        comparacao.clear();
        return "Comparação limpa!";
    }
}

