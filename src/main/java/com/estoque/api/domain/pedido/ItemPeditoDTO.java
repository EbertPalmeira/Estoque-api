package com.estoque.api.domain.pedido;

import jakarta.validation.constraints.NotNull;

public record ItemPeditoDTO(
        @NotNull Long produtoId,
        @NotNull Integer quantidade
) {
}
