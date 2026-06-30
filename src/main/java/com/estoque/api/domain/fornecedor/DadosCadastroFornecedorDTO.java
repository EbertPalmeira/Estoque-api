package com.estoque.api.domain.fornecedor;

import jakarta.validation.constraints.NotBlank;


public record DadosCadastroFornecedorDTO(

        @NotBlank
        String nome,

        @NotBlank
        String cnpj,

        @NotBlank
        String email,

        @NotBlank
        String telefone
) {
}
