package com.estoque.api.service;

import com.estoque.api.domain.categoria.Categoria;
import com.estoque.api.domain.categoria.CategoriaRepository;
import com.estoque.api.domain.categoria.DadosCadastroCategoriaDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoriaServiceTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaService service;

    private DadosCadastroCategoriaDTO dto;

    @Test
    void deveriaCadastrarCategoria() {
        var dados = new DadosCadastroCategoriaDTO("PERFUMADOS");
        var categoria = new Categoria(dados);

        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);

        var resultado = service.cadastrar(dados);


        assertNotNull(resultado);
        assertEquals(resultado.getNome(), "PERFUMADOS");

    }

}