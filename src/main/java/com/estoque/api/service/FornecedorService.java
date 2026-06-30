package com.estoque.api.service;

import com.estoque.api.domain.fornecedor.DadosCadastroFornecedorDTO;
import com.estoque.api.domain.fornecedor.Fornecedor;
import com.estoque.api.domain.fornecedor.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor cadastrar(DadosCadastroFornecedorDTO dados){
        var fornecedor= this.fornecedorRepository.save(new Fornecedor(dados));
        return fornecedorRepository.save(fornecedor);
    }

}
