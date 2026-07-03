package com.estoque.api.domain.cliente;

public record DadosAtualizacaoClienteDTO(
        String id,
        String nome ,
        String cpf,
        String email
) {
}
