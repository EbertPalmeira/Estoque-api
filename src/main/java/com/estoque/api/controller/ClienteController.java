package com.estoque.api.controller;

import com.estoque.api.domain.cliente.Cliente;
import com.estoque.api.domain.cliente.DadosAtualizacaoClienteDTO;
import com.estoque.api.domain.cliente.DadosCadastroClienteDTO;
import com.estoque.api.domain.cliente.DadosListagemClienteDTO;
import com.estoque.api.service.ClienteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
@SecurityRequirement(name = "bearer-key")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar (@RequestBody DadosCadastroClienteDTO dados) {
        var cliente = this.clienteService.cadastrar(dados);
        return ResponseEntity.ok().body(new DadosListagemClienteDTO(cliente));
    }

    @GetMapping
    @Transactional
    public ResponseEntity <Page<DadosListagemClienteDTO>> listar (@PageableDefault(size =10 , sort = "nome") Pageable paginacao) {
        var page = clienteService.listar(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar (@RequestBody DadosAtualizacaoClienteDTO dados) {
        var cliente = this.clienteService.atualizar(dados);
        return ResponseEntity.ok().body(new DadosListagemClienteDTO(cliente));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity deletar (@PathVariable Long id) {
        this.clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
