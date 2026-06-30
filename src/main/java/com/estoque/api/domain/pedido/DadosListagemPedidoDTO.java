package com.estoque.api.domain.pedido;

import java.time.LocalDate;

public record DadosListagemPedidoDTO(
        Long id,
        String cliente,
        Status status,
        LocalDate dataPedido,
        Double total,
        Integer quantidadeItens
) {
    public DadosListagemPedidoDTO(Pedido pedido) {
        this(
                pedido.getId(),
                pedido.getCliente().getNome(),
                pedido.getStatus(),
                pedido.getDataPedido(),
                pedido.getTotal(),
                pedido.getItens().size()
        );
    }
}