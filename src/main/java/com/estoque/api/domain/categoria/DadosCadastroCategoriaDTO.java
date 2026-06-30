package com.estoque.api.domain.categoria;

import jakarta.validation.constraints.NotBlank;


public record DadosCadastroCategoriaDTO(

        @NotBlank
        String nome



) {
}
