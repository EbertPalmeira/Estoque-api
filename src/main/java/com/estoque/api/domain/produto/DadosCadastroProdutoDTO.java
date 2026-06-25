package com.estoque.api.domain.produto;

import com.estoque.api.domain.categoria.Categoria;
import com.estoque.api.domain.fornecedor.Fornecedor;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProdutoDTO(

        @NotNull
        String nome,

        @NotNull
        String descricao,

        @NotNull
        Double preco,

        @NotNull
        Integer quantidade,

        Categoria categoria,

        Fornecedor fornecedor

) {
}
