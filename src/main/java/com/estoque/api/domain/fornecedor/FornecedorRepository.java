package com.estoque.api.domain.fornecedor;

import com.estoque.api.domain.produto.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    Page<Fornecedor> findAllByAtivoTrue(Pageable paginacao);


}
