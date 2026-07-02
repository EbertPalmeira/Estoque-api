package com.estoque.api.controller;

import com.estoque.api.domain.categoria.Categoria;
import com.estoque.api.domain.categoria.DadosCadastroCategoriaDTO;
import com.estoque.api.domain.categoria.DadosDetalhamentoCategoriaDTO;
import com.estoque.api.service.CategoriaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categoria")
@SecurityRequirement(name = "bearer-key")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCategoriaDTO dados){
        var categoria = this.categoriaService.cadastrar(dados);

        return ResponseEntity.ok().body(new DadosDetalhamentoCategoriaDTO(categoria));


    }
}
