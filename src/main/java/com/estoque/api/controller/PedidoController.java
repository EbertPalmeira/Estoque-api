package com.estoque.api.controller;

import com.estoque.api.domain.pedido.DadosCadastroPedidoDTO;
import com.estoque.api.domain.pedido.DadosDetalhamentoPedidoDTO;
import com.estoque.api.domain.pedido.Status;
import com.estoque.api.domain.pedido.StatusRequest;
import com.estoque.api.service.PedidoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedido")
@SecurityRequirement(name = "bearer-key")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPedidoDTO dados){
        var pedido = this.pedidoService.cadastrar(dados);

        return ResponseEntity.ok().body(new DadosDetalhamentoPedidoDTO(pedido));
    }

    @PutMapping("/{id}/status")
    @Transactional
    public ResponseEntity atualizarStatus(@PathVariable Long id, @RequestBody @Valid StatusRequest statusRequest){
        var pedido = pedidoService.atualizarStatus(id,statusRequest.status());
        return ResponseEntity.ok().body(new DadosDetalhamentoPedidoDTO(pedido));
    }
}
