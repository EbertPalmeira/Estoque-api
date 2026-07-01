package com.estoque.api.domain.fornecedor;


import com.estoque.api.domain.categoria.DadosCadastroCategoriaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "fornecedor")
@Entity(name = "fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cnpj;

    private String email;

    private String telefone;

    private boolean ativo = true;

    public Fornecedor(DadosCadastroFornecedorDTO dados) {
        this.nome = dados.nome();
        this.cnpj = dados.cnpj();
        this.email = dados.email();
        this.telefone = dados.telefone();
    }
    public void atualizar(DadosAtualizacaoFornecedorDTO dados){
        this.nome = dados.nome();
        this.cnpj = dados.cnpj();
        this.email = dados.email();
    }

    public void excluir() {
        this.ativo = false;
    }



}
