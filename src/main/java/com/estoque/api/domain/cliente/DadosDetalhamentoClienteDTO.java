package com.estoque.api.domain.cliente;

public record DadosDetalhamentoClienteDTO(
        Long Id,
        String nome,
        String cpf,
        String email
) {
    public DadosDetalhamentoClienteDTO(Cliente cliente){
        this(cliente.getId(),cliente.getNome(), cliente.getCpf(), cliente.getEmail());
    }
}
