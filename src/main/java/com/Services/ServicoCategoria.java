package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repositories.RepositorioCategoria;
import com.entities.Categoria;

@Service
public class ServicoCategoria
{
  @Autowired
  private RepositorioCategoria repositorio;
  
  public List<Categoria> findAll()
  {
    return repositorio.findAll();
  }

  public Categoria findById(Long id)
  {
    Optional<Categoria> obj = repositorio.findById(id);
    return obj.get();
  }
}
