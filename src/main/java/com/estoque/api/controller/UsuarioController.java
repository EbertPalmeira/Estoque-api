package com.estoque.api.controller;

import com.estoque.api.domain.usuario.DadosCadastroUsuarioDTO;
import com.estoque.api.domain.usuario.Usuario;
import com.estoque.api.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder enconder;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody DadosCadastroUsuarioDTO dados) {

        var senhaCriptografada= enconder.encode(dados.senha());

        var usuario= new Usuario(dados.login(),senhaCriptografada);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }
}
