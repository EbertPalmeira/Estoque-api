package com.estoque.api.domain.cliente;

import com.estoque.api.domain.produto.DadosListagemProdutoDTO;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;

public record DadosListagemClienteDTO(
        @NotNull
        Long Id,
        String nome,
        String cpf,
        String email
) {

    public DadosListagemClienteDTO (Cliente cliente ) {
        this(cliente.getId(),cliente.getNome(),cliente.getCpf(),cliente.getEmail());
    }
}
