package com.estoque.api.domain.fornecedor;

import com.estoque.api.domain.produto.DadosDetalhamentoProdutoDTO;

public record DadosDetalhamentoFornecedorDTO(

        String nome,
        String cnpj,
        String email,
        String telefone

) {
    public DadosDetalhamentoFornecedorDTO(Fornecedor fornecedor){
        this(fornecedor.getNome(), fornecedor.getCnpj(),  fornecedor.getEmail(), fornecedor.getTelefone());
    }
}
