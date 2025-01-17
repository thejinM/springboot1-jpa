package com.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_Produto")
public class Produto implements Serializable
{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String descricao;
  private double preco;
  private String imgURL;

  @ManyToMany
  @JoinTable(name = "TB_Produto_Categoria", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
  private Set<Categoria> categorias = new HashSet<>();

  @OneToMany(mappedBy = "id.produto")
  private Set<ItemPedido> itens = new HashSet<>();

  public Produto () {}

  public Produto(Long id, String nome, String descricao, double preco, String imgURL) 
  {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.imgURL = imgURL;
  }

  public Long getId() 
  {
    return id;
  }

  public void setId(Long id) 
  {
    this.id = id;
  }

  public String getNome() 
  {
    return nome;
  }

  public void setNome(String nome) 
  {
    this.nome = nome;
  }

  public String getDescricao() 
  {
    return descricao;
  }

  public void setDescricao(String descricao) 
  {
    this.descricao = descricao;
  }

  public double getPreco() 
  {
    return preco;
  }

  public void setPreco(double preco) 
  {
    this.preco = preco;
  }

  public String getImgURL() 
  {
    return imgURL;
  }

  public void setImgURL(String imgURL) 
  {
    this.imgURL = imgURL;
  }

  public Set<Categoria> getCategorias() 
  {
    return categorias;
  }

  public Set<Pedido> getPedidos()
  {
    Set<Pedido> set = new HashSet<>();
    for (ItemPedido x : itens)
    {
      set.add(x.getPedido());
    }
    return set;
  }

  @Override
  public int hashCode() 
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
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
    Produto other = (Produto) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }  
}