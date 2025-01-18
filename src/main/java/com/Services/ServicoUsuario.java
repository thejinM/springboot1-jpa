package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repositories.RepositorioUsuario;
import com.Services.exceptions.ExceptionRecursoNaoEncontrado;
import com.entities.Usuario;

@Service
public class ServicoUsuario 
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
    return obj.orElseThrow(() -> new ExceptionRecursoNaoEncontrado(id));
  }

  public Usuario inserir(Usuario obj)
  {
    return repositorio.save(obj);
  }

  public void deletar(Long id)
  {
    repositorio.deleteById(id);
  }

  public Usuario atualizar(Long id, Usuario obj)
  {
    Usuario entidade = repositorio.getReferenceById(id);
    atualizarDados(entidade, obj);
    return repositorio.save(entidade);
  }

  public void atualizarDados(Usuario entidade, Usuario obj)
  {
    entidade.setNome(obj.getNome());
    entidade.setEmail(obj.getEmail());
    entidade.setFone(obj.getFone());
  }
}