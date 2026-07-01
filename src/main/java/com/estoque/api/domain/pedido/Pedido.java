package com.estoque.api.domain.pedido;


import com.estoque.api.domain.cliente.Cliente;
import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "pedido")
@Table(name = "pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate dataPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens = new ArrayList<>();

    private Double total;

    public Pedido(DadosCadastroPedidoDTO dados, Cliente cliente, Status status) {
        this.cliente=cliente;
        this.status=status;
        this.dataPedido=LocalDate.now();
        this.total = 0.0;
    }
    public void atualizar(DadosAtualizacaoPedidoDTO dados) {
        if (dados.status() != null) {
            this.status = dados.status();
        }

        if (dados.dataPedido() != null) {
            this.dataPedido = dados.dataPedido();
        }

    }


    public void setTotal(double total) {
        this.total = total;
    }


}
