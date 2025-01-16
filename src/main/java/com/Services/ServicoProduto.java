package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repositories.RepositorioUsuario;
import com.entities.Usuario;

@Service
public class ServicoProduto
{
  @Autowired
  private RepositorioUsuario repositorio;
  
  public List<Usuario> findAll()
  {
    return repositorio.findAll();
  }

  public Usuario findById(Long id)
  {
    Optional<Usuario> obj = repositorio.findById(id);
    return obj.get();
  }
}
