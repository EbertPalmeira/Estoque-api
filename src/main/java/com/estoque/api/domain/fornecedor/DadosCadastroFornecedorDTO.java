package com.estoque.api.domain.fornecedor;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroFornecedorDTO(

        @NotNull
        String nome,

        @NotNull
        String cnpj,

        @NotNull
        String email,

        @NotNull
        String telefone
) {
}
