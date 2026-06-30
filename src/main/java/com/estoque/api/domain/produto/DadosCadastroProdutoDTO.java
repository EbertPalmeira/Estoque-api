package com.estoque.api.domain.produto;

import com.estoque.api.domain.categoria.Categoria;
import com.estoque.api.domain.fornecedor.Fornecedor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProdutoDTO(

        @NotBlank String nome,
        @NotBlank  String descricao,
        @NotNull Double preco,
        @NotNull Integer quantidade,
        @NotNull Long categoriaId,
        @NotNull Long fornecedorId

) {

}
