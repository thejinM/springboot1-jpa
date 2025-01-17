package com.entities;

import java.io.Serializable;

import com.entities.pk.ItemPedidoPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ItemPedido")
public class ItemPedido implements Serializable
{
  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private ItemPedidoPK id = new ItemPedidoPK();

  private Integer quantidade;
  private Double preco;

  public ItemPedido() {}

  public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) 
  {
    super();
    id.setPedido(pedido);
    id.setProduto(produto);
    this.quantidade = quantidade;
    this.preco = preco;
  }

  @JsonIgnore
  public Pedido getPedido()
  {
    return id.getPedido();
  }

  public void setPedido(Pedido pedido)
  {
    id.setPedido(pedido);
  }

  @JsonIgnore
  public Produto getProduto()
  {
    return id.getProduto();
  }

  public void setProduto(Produto produto)
  {
    id.setProduto(produto);
  } 

  public Integer getQuantidade() 
  {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) 
  {
    this.quantidade = quantidade;
  }

  public Double getPreco() 
  {
    return preco;
  }

  public void setPreco(Double preco) 
  {
    this.preco = preco;
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
    ItemPedido other = (ItemPedido) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }  
}