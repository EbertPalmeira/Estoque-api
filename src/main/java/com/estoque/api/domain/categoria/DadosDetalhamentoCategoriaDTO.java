package com.estoque.api.domain.categoria;

public record DadosDetalhamentoCategoriaDTO(
        String nome
) {

    public DadosDetalhamentoCategoriaDTO(Categoria categoria){
        this(categoria.getNome());
    }
}
