package com.estoque.api.domain.pedido;

import java.time.LocalDate;

public record DadosAtualizacaoPedidoDTO(
        Long Id,
        Long clienteId,
        Status status,
        LocalDate dataPedido,
        Integer quantidadeItens
) {
}
