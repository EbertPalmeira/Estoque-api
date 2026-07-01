package com.estoque.api.domain.pedido;

import java.time.LocalDate;

public record DadosDetalhamentoPedidoDTO(
        Long id,
        Long clienteId,
        String nomeCliente,
        String status,
        LocalDate dataPedido,
        Double total,
        Integer quantidadeItens

) {
    public DadosDetalhamentoPedidoDTO(Pedido pedido){
        this(
                pedido.getId(),
                pedido.getCliente().getId(),
                pedido.getCliente().getNome(),
                pedido.getStatus().toString(),
                pedido.getDataPedido(),
                pedido.getTotal(),
                pedido.getItens().size()
        );
    }
}
