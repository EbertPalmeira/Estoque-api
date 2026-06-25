package com.estoque.api.domain.produto;

import com.estoque.api.domain.categoria.Categoria;
import com.estoque.api.domain.fornecedor.Fornecedor;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProdutoDTO(

        @NotNull
        Long id,

        String nome,

        String descricao,

        Double preco,

        Integer quantidade,

        Categoria categoria,

        Fornecedor fornecedor
) {
}
