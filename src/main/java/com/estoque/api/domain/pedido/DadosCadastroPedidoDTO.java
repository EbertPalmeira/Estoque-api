package com.estoque.api.domain.pedido;

import com.estoque.api.domain.cliente.Cliente;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record DadosCadastroPedidoDTO(
        @NotNull Long clienteId,
        LocalDate dataPedido,
        @NotNull List<ItemPeditoDTO> itens

) {
}
