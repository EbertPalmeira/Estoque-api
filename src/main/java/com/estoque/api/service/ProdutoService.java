package com.estoque.api.service;

import com.estoque.api.domain.produto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;


    public Produto cadastrar(DadosCadastroProdutoDTO dados){
        var produto = new Produto(dados);
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
        var produto = repository.findAllById(id);



    }

}
