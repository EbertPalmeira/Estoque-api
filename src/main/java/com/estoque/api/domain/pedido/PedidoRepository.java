package com.estoque.api.domain.pedido;

import com.estoque.api.domain.produto.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Page<Produto> findAllByAtivoTrue(Pageable paginacao);
}
