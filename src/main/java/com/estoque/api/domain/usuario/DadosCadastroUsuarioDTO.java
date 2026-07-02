package com.estoque.api.domain.usuario;

public record DadosCadastroUsuarioDTO (
        String login,
        String senha

){
    public DadosCadastroUsuarioDTO(DadosCadastroUsuarioDTO dados) {
        this(dados.login, dados.senha);
    }
}
