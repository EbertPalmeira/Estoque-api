package com.estoque.api.service;


import com.estoque.api.domain.cliente.Cliente;
import com.estoque.api.domain.cliente.DadosAtualizacaoClienteDTO;
import com.estoque.api.domain.cliente.DadosCadastroClienteDTO;
import com.estoque.api.domain.fornecedor.DadosAtualizacaoFornecedorDTO;
import com.estoque.api.domain.fornecedor.DadosCadastroFornecedorDTO;
import com.estoque.api.domain.fornecedor.Fornecedor;
import com.estoque.api.domain.fornecedor.FornecedorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FornecedorServiceTest {

    @Mock
    private FornecedorRepository repository;


    @InjectMocks
    FornecedorService service;

    @Test
    void deveriaCadastrarFornecedor(){
        var dados = new DadosCadastroFornecedorDTO("julio","325235325", "julio@gmial","5353252352");

        var fornecedor = new Fornecedor(dados);

        when(repository.save(any(Fornecedor.class))).thenReturn(fornecedor);

        var resultado = service.cadastrar(dados);


        assertEquals(resultado.getNome(), "julio");
        assertEquals(resultado.getCnpj(), "325235325");
        assertEquals(resultado.getEmail(), "julio@gmial");
        assertEquals(resultado.getTelefone(), "5353252352");
        assertNotNull(resultado);


    }

    @Test
    void deveriaListarFornecedor(){

        //arrange
        var dados =new DadosCadastroFornecedorDTO("sergio", "655325", "sergio@gmail","6853252352");

        var fornecedor = new Fornecedor(dados);

        var lista= List.of(fornecedor);

        var page = new PageImpl<>(lista);
        when(repository.findAllByAtivoTrue(any(Pageable.class))).thenReturn(page);

        //act
        var resultado = service.listar(Pageable.unpaged());

        //assert
        assertEquals(resultado.getTotalPages(), page.getTotalPages());
        assertNotNull(resultado,"Não e nulo");
        Mockito.verify(repository, Mockito.times(1)).findAllByAtivoTrue(any(Pageable.class));
    }
    @Test
    void deveriaAtualizarFornecedor(){

        //arrange
        var dados= new DadosCadastroFornecedorDTO("gustavo", "325235325", "hugo@gmail","5353252352");

        var fornecedor  = new Fornecedor(dados);

        var dadosAtualizados= new DadosAtualizacaoFornecedorDTO(1L, "leandro atualizado","2312321321","lucas@gmail.com");
        fornecedor.setId(1L);

        when(repository.getReferenceById(1L)).thenReturn(fornecedor);
        when(repository.save(any(Fornecedor.class))).thenReturn(fornecedor);


        //act
        var resultado = service.atualizar(dadosAtualizados);

        assertNotNull(resultado);
        assertEquals("leandro atualizado", resultado.getNome());
        assertEquals("2312321321", resultado.getCnpj());
        assertEquals("lucas@gmail.com", resultado.getEmail());
        verify(repository,times(1)).save(any(Fornecedor.class));

    }

    @Test
    void deveriaExcluirFornecedor(){
        var dados = new DadosCadastroFornecedorDTO("ebert", "325235325", "ebert@gmail","5353252352");
        var fornecedor = new Fornecedor(dados);

        fornecedor.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(fornecedor));


        //act
        service.excluir(1L);


        //assert
        verify(repository,times(1)).findById(1L);
        verify(repository,times(1)).save(any(Fornecedor.class));
    }

}