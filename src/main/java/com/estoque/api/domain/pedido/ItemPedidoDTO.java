package com.estoque.api.domain.pedido;

import jakarta.validation.constraints.NotNull;

public record ItemPedidoDTO(
        @NotNull Long produtoId,
        @NotNull Integer quantidade
) {
}
