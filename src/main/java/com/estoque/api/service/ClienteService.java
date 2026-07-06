package com.estoque.api.service;

import com.estoque.api.domain.cliente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrar(DadosCadastroClienteDTO dados){
        var cliente = new Cliente(dados);
        return clienteRepository.save(cliente);


    }
    public Page<DadosListagemClienteDTO> listar(Pageable paginacao){
        var page = clienteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemClienteDTO::new);
        return page;
    }

    public Cliente atualizar(DadosAtualizacaoClienteDTO dados){
        var cliente = clienteRepository.getReferenceById(dados.id());
        if (dados.nome() != null) {
            cliente.setNome(dados.nome());
        }
        if (dados.cpf() != null) {
            cliente.setCpf(dados.cpf());
        }
        if (dados.email() != null) {
            cliente.setEmail(dados.email());
        }


        return clienteRepository.save(cliente);
    }
    public void excluir(Long id){
        var cliente = clienteRepository.findById(id);
    }
}
