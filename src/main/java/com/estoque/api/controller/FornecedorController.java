package com.estoque.api.controller;

import com.estoque.api.domain.fornecedor.DadosAtualizacaoFornecedorDTO;
import com.estoque.api.domain.fornecedor.DadosCadastroFornecedorDTO;
import com.estoque.api.domain.fornecedor.DadosDetalhamentoFornecedorDTO;
import com.estoque.api.domain.fornecedor.DadosListagemFornecedorDTO;
import com.estoque.api.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    @Transactional
    public ResponseEntity <Page<DadosListagemFornecedorDTO>> listar(@PageableDefault(size = 10,sort = "nome") Pageable pageable){
        var page = this.fornecedorService.listar(pageable);
        return ResponseEntity.ok().body(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(DadosAtualizacaoFornecedorDTO dados){
        var  fornecedor= this.fornecedorService.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoFornecedorDTO(fornecedor));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long Id){
        this.fornecedorService.excluir(Id);
        return ResponseEntity.noContent().build();
    }
}
