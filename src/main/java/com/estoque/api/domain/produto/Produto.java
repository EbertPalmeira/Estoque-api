package com.estoque.api.domain.produto;

import com.estoque.api.domain.categoria.Categoria;
import com.estoque.api.domain.fornecedor.Fornecedor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "produto")
@Table(name = "produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private Double preco;

    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    private boolean ativo = true;

    public Produto(DadosCadastroProdutoDTO dados) {
        this.nome= dados.nome();
        this.descricao = dados.descricao();
        this.preco = dados.preco();
        this.quantidade = dados.quantidade();
        this.categoria = dados.categoria();
        this.fornecedor = dados.fornecedor();

    }

    public void atualizar(DadosAtualizacaoProdutoDTO dados){
        this.nome= dados.nome();
        this.descricao = dados.descricao();
        this.preco = dados.preco();
        this.quantidade = dados.quantidade();
        this.categoria = dados.categoria();
        this.fornecedor = dados.fornecedor();
    }
    public void excluir() {
        this.ativo = false;
    }

    public void setId(long Id) {
    }
}
