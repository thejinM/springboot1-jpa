package com.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursosUsuario 
{
  @GetMapping
  public ResponseEntity<Usuario> encontrarTodos()
  {
    Usuario u = new Usuario (1, "Bárbara", "barbara@gmail.com", "99876-5432", "barbara123");
    return ResponseEntity.ok().body(u);
  }
}