package com.estoque.api.domain.produto;

import com.estoque.api.domain.categoria.Categoria;
import com.estoque.api.domain.fornecedor.Fornecedor;
import jakarta.validation.constraints.NotNull;

public record DadosDetalhamentoProdutoDTO(

        Long Id,

        String nome,

        String descricao,

        Double preco,

        Integer quantidade,

        Categoria categoria,

        Fornecedor fornecedor


) {
    public DadosDetalhamentoProdutoDTO(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(),produto.getQuantidade(),produto.getCategoria(),produto.getFornecedor());
    }
}
