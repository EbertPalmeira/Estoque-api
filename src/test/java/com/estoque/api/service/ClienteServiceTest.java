package com.estoque.api.service;

import com.estoque.api.domain.cliente.Cliente;
import com.estoque.api.domain.cliente.ClienteRepository;
import com.estoque.api.domain.cliente.DadosAtualizacaoClienteDTO;
import com.estoque.api.domain.cliente.DadosCadastroClienteDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
    void deveriaAtualizarCliente(){

        var dados =new DadosCadastroClienteDTO("hugo", "325235325", "hugo@gmial");

        var cliente = new Cliente(dados);

        var lista= List.of(cliente);

        var page = new PageImpl<>(lista);
        when(clienteRepository.findAllByAtivoTrue(any())).thenReturn(Optional.of(cliente));
    }

}