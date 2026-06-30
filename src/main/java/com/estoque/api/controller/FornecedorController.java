package com.estoque.api.controller;

import com.estoque.api.domain.fornecedor.DadosCadastroFornecedorDTO;
import com.estoque.api.domain.fornecedor.DadosDetalhamentoFornecedorDTO;
import com.estoque.api.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroFornecedorDTO dados){
        var fornecedor= this.fornecedorService.cadastrar(dados);
        return ResponseEntity.ok().body(new DadosDetalhamentoFornecedorDTO(fornecedor));
    }
}
