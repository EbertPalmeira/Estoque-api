package com.estoque.api.domain.cliente;

public record DadosAtualizacaoClienteDTO(
        Long id,
        String nome ,
        String cpf,
        String email
) {
}
