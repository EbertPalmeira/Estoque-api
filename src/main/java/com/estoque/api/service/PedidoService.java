package com.estoque.api.service;

import com.estoque.api.domain.cliente.ClienteRepository;
import com.estoque.api.domain.pedido.*;
import com.estoque.api.domain.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    @Transactional
    public Pedido cadastrar(DadosCadastroPedidoDTO dados) {

        var cliente = clienteRepository.findById(dados.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        var pedido = new Pedido(dados,cliente , Status.PENDENTE);

        double total = 0.0;

        for (ItemPedidoDTO itemDTO : dados.itens()) {
            // Buscar o produto
            var produto = produtoRepository.findById(itemDTO.produtoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + itemDTO.produtoId()));

            // Verificar estoque
            if (produto.getQuantidade() < itemDTO.quantidade()) {
                throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNome());
            }

            double subtotal = itemDTO.quantidade() * produto.getPreco();

            var item = new ItemPedido();
            item.setQuantidade(itemDTO.quantidade());
            item.setPrecoUnitario(produto.getPreco());
            item.setSubtotal(subtotal);
            item.setProduto(produto);
            item.setPedido(pedido);


            // Adicionar item ao pedido
            pedido.getItens().add(item);

            // Atualizar estoque
            produto.setQuantidade(produto.getQuantidade() - itemDTO.quantidade());
            produtoRepository.save(produto);


            total += subtotal;
        }

        pedido.setTotal(total);

        System.out.println("💾 Salvando pedido com total: " + total);
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizarStatus(Long id, Status novoStatus) {
        var pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedido.setStatus(novoStatus);
        return pedidoRepository.save(pedido);


    }

}
