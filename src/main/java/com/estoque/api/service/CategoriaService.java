package com.estoque.api.service;

import com.estoque.api.domain.categoria.Categoria;
import com.estoque.api.domain.categoria.CategoriaRepository;
import com.estoque.api.domain.categoria.DadosCadastroCategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria cadastrar(DadosCadastroCategoriaDTO dados){
        var categoria = new Categoria(dados);
        return categoriaRepository.save(categoria);

    }
}
