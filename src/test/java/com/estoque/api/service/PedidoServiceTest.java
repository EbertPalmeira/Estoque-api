package com.estoque.api.service;

import com.estoque.api.domain.cliente.Cliente;
import com.estoque.api.domain.cliente.ClienteRepository;
import com.estoque.api.domain.pedido.DadosCadastroPedidoDTO;
import com.estoque.api.domain.pedido.ItemPedido;
import com.estoque.api.domain.pedido.Pedido;
import com.estoque.api.domain.pedido.PedidoRepository;
import com.estoque.api.domain.produto.Produto;
import com.estoque.api.domain.produto.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {

    @Mock
    PedidoRepository repository;

    @Mock
    ClienteRepository clienteRepository;

    @Mock
    ProdutoRepository produtoRepository;

    @InjectMocks
    PedidoService service;

    @Test
    void deveriaCadastrarPedido() {
        var cliente =  new Cliente();
        cliente.setId(1L);
        cliente.setNome("Cliente 1");

        var produto1 = new Produto();
        produto1.setId(1L);
        produto1.setNome("Notebook");

        var produto2 = new Produto();
        produto2.setId(2L);
        produto2.setNome("Mouse");

        var itens = List.of(
                new ItemPedido(1L , 2),

        );
    }


}