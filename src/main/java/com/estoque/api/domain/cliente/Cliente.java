package com.estoque.api.domain.cliente;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "cliente")
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private boolean ativo = true;

    public void setId(long Id) {
    }

    public Cliente(DadosCadastroClienteDTO dados){
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();

    }
    public void atualizar(DadosAtualizacaoClienteDTO dados){
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();

    }
    public void excluir() {
        this.ativo = false;
    }

}
