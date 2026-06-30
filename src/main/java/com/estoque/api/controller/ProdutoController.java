package com.estoque.api.controller;


import com.estoque.api.domain.produto.*;
import com.estoque.api.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar( @RequestBody @Valid DadosCadastroProdutoDTO dados){
        var produto = this.produtoService.cadastrar(dados);

        return ResponseEntity.ok().body(new DadosDetalhamentoProdutoDTO(produto));
    }

    @GetMapping
    @Transactional
    public ResponseEntity <Page<DadosListagemProdutoDTO>> listar(@PageableDefault(size =10 , sort = "nome") Pageable paginacao){
        var page = this.produtoService.listar(paginacao);

        return ResponseEntity.ok(page);

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody DadosAtualizacaoProdutoDTO dados){
        var produto = this.produtoService.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoProdutoDTO(produto));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long Id){
        this.produtoService.excluir(Id);
        return ResponseEntity.noContent().build();
    }


}
