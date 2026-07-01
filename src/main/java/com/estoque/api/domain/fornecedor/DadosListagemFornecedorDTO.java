package com.estoque.api.domain.fornecedor;

import com.estoque.api.domain.produto.Produto;
import jakarta.validation.constraints.NotNull;

public record DadosListagemFornecedorDTO(
        @NotNull
        Long Id,
        String nome,
        String cnpj,
        String email

) {
    public DadosListagemFornecedorDTO(Fornecedor fornecedor){
        this(
                fornecedor.getId(),
                fornecedor.getNome(),
                fornecedor.getCnpj(),
                fornecedor.getEmail()
        );
    }

}
