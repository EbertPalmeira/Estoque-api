package com.estoque.api.domain.fornecedor;

public record DadosAtualizacaoFornecedorDTO (
        Long id,
        String nome,
        String cnpj,
        String email
){
}
