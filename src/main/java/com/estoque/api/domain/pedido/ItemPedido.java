package com.estoque.api.domain.pedido;


import com.estoque.api.domain.produto.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "item-pedido")
@Table(name = "item-pedido")
public class ItemPedido {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  Integer quantidade;

    private Double precoUnitario;

    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;




}
