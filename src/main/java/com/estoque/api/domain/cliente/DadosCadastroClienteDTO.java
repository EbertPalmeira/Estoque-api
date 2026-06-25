package com.estoque.api.domain.cliente;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroClienteDTO(
        @NotNull
        String nome,

        @NotNull
        String cpf,

        @NotNull
        String email

) {
}
