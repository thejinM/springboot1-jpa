package com.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class Usuario implements Serializable
{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private String email;
  private String fone;
  private String senha;

  public Usuario() {}

  public Usuario(long id, String name, String email, String fone, String senha) 
  {
    super();
    this.id = id;
    this.name = name;
    this.email = email;
    this.fone = fone;
    this.senha = senha;
  }

  public long getId() 
  {
    return id;
  }

  public void setId(long id) 
  {
    this.id = id;
  }

  public String getName() 
  {
    return name;
  }

  public void setName(String name) 
  {
    this.name = name;
  }

  public String getEmail() 
  {
    return email;
  }

  public void setEmail(String email) 
  {
    this.email = email;
  }

  public String getFone() 
  {
    return fone;
  }

  public void setFone(String fone) 
  {
    this.fone = fone;
  }

  public String getSenha() 
  {
    return senha;
  }

  public void setSenha(String senha) 
  {
    this.senha = senha;
  }

  @Override
  public int hashCode() 
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) 
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Usuario other = (Usuario) obj;
    if (id != other.id)
      return false;
    return true;
  }
}