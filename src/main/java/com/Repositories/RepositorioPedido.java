package com.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Pedido;

public interface RepositorioPedido extends JpaRepository<Pedido, Long> 
{
    
} 