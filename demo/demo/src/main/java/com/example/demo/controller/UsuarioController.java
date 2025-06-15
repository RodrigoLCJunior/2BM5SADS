package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    private ResponseEntity<List<Usuario>> buscarTodosUsuarios(){
        List<Usuario> usuariosList = usuarioService.buscarTodosUsuarios();
        if(usuariosList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuariosList);
    }

    @PostMapping
    private ResponseEntity<Usuario> criarUsuario(Usuario usuario){
        Usuario usuarioNovo = usuarioService.criarUsuario(usuario);
        if (usuarioNovo == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioNovo);
    }

}
