package com.estoque.api.service;

import com.estoque.api.domain.cliente.Cliente;
import com.estoque.api.domain.cliente.ClienteRepository;
import com.estoque.api.domain.cliente.DadosAtualizacaoClienteDTO;
import com.estoque.api.domain.cliente.DadosCadastroClienteDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @InjectMocks
    ClienteService service;

    @Mock
    private ClienteRepository clienteRepository;


    @Test
    void deveriaCadastrarCliente(){
    var dados = new DadosCadastroClienteDTO("julio","325235325", "julio@gmial");

    var cliente = new Cliente(dados);

    when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

    var resultado = service.cadastrar(dados);


    assertEquals(resultado.getNome(), "julio");
    assertEquals(resultado.getCpf(), "325235325");
    assertEquals(resultado.getEmail(), "julio@gmial");
    assertNotNull(resultado);


    }

    @Test
    void deveriaListarCliente(){

        //arrange
        var dados =new DadosCadastroClienteDTO("hugo", "325235325", "hugo@gmial");

        var cliente = new Cliente(dados);

        var lista= List.of(cliente);

        var page = new PageImpl<>(lista);
        when(clienteRepository.findAllByAtivoTrue(any(Pageable.class))).thenReturn(page);

        //act
        var resultado = service.listar(Pageable.unpaged());

        //assert
        assertEquals(resultado.getTotalPages(), page.getTotalPages());
        assertNotNull(resultado,"Não e nulo");
        Mockito.verify(clienteRepository, Mockito.times(1)).findAllByAtivoTrue(any(Pageable.class));
    }

    @Test
    void deveriaAtualizarCliente(){

        //arrange
        var dados= new DadosCadastroClienteDTO("hugo", "325235325", "hugo@gmial");

        var cliente  = new Cliente(dados);

        var dadosAtualizados= new DadosAtualizacaoClienteDTO(1L, "hugo atualizado","2312321321","lucas@gmail.com");
        cliente.setId(1L);

        when(clienteRepository.getReferenceById(1L)).thenReturn(cliente);
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);


        //act
        var resultado = service.atualizar(dadosAtualizados);

        assertNotNull(resultado);
        assertEquals("hugo atualizado", resultado.getNome());
        assertEquals("2312321321", resultado.getCpf());
        assertEquals("lucas@gmail.com", resultado.getEmail());
        verify(clienteRepository,times(1)).save(any(Cliente.class));

    }

    @Test
    void deveriaExcluirCliente(){
        var dados = new DadosCadastroClienteDTO("hugo", "325235325", "hugo@gmial");
        var aluno = new Cliente(dados);

        aluno.setId(1L);
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(aluno));


        //act
        service.excluir(1L);


        //assert
        verify(clienteRepository,times(1)).findById(1L);
        verify(clienteRepository,times(1)).save(any(Cliente.class));
    }
}