package com.estoque.api.service;

import com.estoque.api.domain.fornecedor.*;
import com.estoque.api.domain.produto.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public Fornecedor cadastrar(DadosCadastroFornecedorDTO dados){
        var fornecedor= this.repository.save(new Fornecedor(dados));
        return repository.save(fornecedor);
    }

    public Page<DadosListagemFornecedorDTO> listar(Pageable paginacao){
        var page =repository.findAllByAtivoTrue(paginacao).map(DadosListagemFornecedorDTO::new);
        return page;
    }

    public Fornecedor atualizar(DadosAtualizacaoFornecedorDTO dados){
        var fornecedor = repository.getReferenceById(dados.id());
        fornecedor.atualizar(dados);
        return repository.save(fornecedor);
    }

    public void excluir(Long id){
        var fornecedor = repository.findById(id);
    }

}
