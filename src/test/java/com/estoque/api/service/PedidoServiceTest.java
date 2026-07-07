package com.estoque.api.service;

import com.estoque.api.domain.cliente.Cliente;
import com.estoque.api.domain.cliente.ClienteRepository;
import com.estoque.api.domain.pedido.*;
import com.estoque.api.domain.produto.Produto;
import com.estoque.api.domain.produto.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.ArgumentMatchers.any;


import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
        produto1.setPreco(3500.00);
        produto1.setQuantidade(10);

        var produto2 = new Produto();
        produto2.setId(2L);
        produto2.setNome("Mouse");
        produto2.setPreco(50.00);
        produto2.setQuantidade(20);

        var itens = List.of(
                new ItemPedidoDTO(1L , 2),
                new ItemPedidoDTO(2L, 1)

        );


        var dados = new DadosCadastroPedidoDTO(1L, itens);

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto1));
        when(produtoRepository.findById(2L)).thenReturn(Optional.of(produto2));
        when(repository.save(any(Pedido.class))).thenAnswer(invocation -> {
            Pedido pedido = invocation.getArgument(0);
            pedido.setId(1L);
            return pedido;
        });


        //act
        var resultado = service.cadastrar(dados);

        //assert
        assertNotNull(resultado);
        assertEquals(7050.00, resultado.getTotal());


    }




}