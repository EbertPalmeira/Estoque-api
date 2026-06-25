package com.estoque.api.domain.pedido;

import com.estoque.api.domain.cliente.Cliente;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroPedidoDTO(
        @NotNull
        Cliente cliente,

        @NotNull
        Status status,

        @NotNull
        LocalDate dataPedido,

        @NotNull
        Long itemPedidoId,

        @NotNull
        Double total

) {
}
