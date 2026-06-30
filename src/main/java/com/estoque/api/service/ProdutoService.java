package com.estoque.api.service;

import com.estoque.api.domain.categoria.Categoria;
import com.estoque.api.domain.categoria.CategoriaRepository;
import com.estoque.api.domain.fornecedor.Fornecedor;
import com.estoque.api.domain.fornecedor.FornecedorRepository;
import com.estoque.api.domain.produto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Produto cadastrar(DadosCadastroProdutoDTO dados){

        var categoria = categoriaRepository.findById(dados.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        var fornecedor = fornecedorRepository.findById(dados.fornecedorId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));



        var produto = new Produto(dados,categoria,fornecedor);
        return repository.save(produto);
    }

    public Page<DadosListagemProdutoDTO> listar(Pageable paginacao){
    var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemProdutoDTO::new);
    return page;
    }

    public Produto atualizar(DadosAtualizacaoProdutoDTO dados){
        var produto= repository.getReferenceById(dados.id());
        produto.atualizar(dados);

        return repository.save(produto);

    }

    public void excluir(Long id){
        var produto = repository.findById(id);

    }

}
