package com.estoque.api.domain.pedido;


import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosCadastroPedidoDTO(
        @NotNull Long clienteId,
        @NotNull List<ItemPedidoDTO> itens

) {
}
