package com.Config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.Repositories.RepositorioCategoria;
import com.Repositories.RepositorioItemPedido;
import com.Repositories.RepositorioPedido;
import com.Repositories.RepositorioProduto;
import com.Repositories.RepositorioUsuario;
import com.entities.Categoria;
import com.entities.ItemPedido;
import com.entities.Pedido;
import com.entities.Produto;
import com.entities.Usuario;
import com.entities.enums.PedidoStatus;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner
{
  @Autowired
  private RepositorioUsuario repositorioUsuario;

  @Autowired
  private RepositorioPedido repositorioPedido;

  @Autowired
  private RepositorioCategoria repositorioCategoria;

  @Autowired
  private RepositorioProduto repositorioProduto;

  @Autowired
  private RepositorioItemPedido repositorioItemPedido;

  @Override
  public void run(String... args) throws Exception 
  {
    Categoria cat1 = new Categoria(null, "Eletrônicos");
    Categoria cat2 = new Categoria(null, "Livros");
    Categoria cat3 = new Categoria(null, "Computadores");

    Produto pr1 = new Produto(null, "O Senhor dos Anéis", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
    Produto pr2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
    Produto pr3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
    Produto pr4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
    Produto pr5 = new Produto(null, "Rails para Leigos", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

    repositorioCategoria.saveAll(Arrays.asList(cat1, cat2, cat3));
    repositorioProduto.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));

    pr1.getCategorias().add(cat2);
    pr2.getCategorias().add(cat1);
    pr2.getCategorias().add(cat3);
    pr3.getCategorias().add(cat3);
    pr4.getCategorias().add(cat3);
    pr5.getCategorias().add(cat2);

    repositorioProduto.saveAll(Arrays.asList(pr1, pr2, pr3, pr4, pr5));

    Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
    Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

    Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1);
    Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u2);
    Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.ENTREGUE, u1);

    repositorioUsuario.saveAll(Arrays.asList(u1, u2));
    repositorioPedido.saveAll(Arrays.asList(p1, p2, p3));

    ItemPedido ip1 = new ItemPedido(p1, pr1, 2, pr1.getPreco());
    ItemPedido ip2 = new ItemPedido(p1, pr3, 1, pr3.getPreco());
    ItemPedido ip3 = new ItemPedido(p2, pr3, 2, pr3.getPreco());
    ItemPedido ip4 = new ItemPedido(p3, pr5, 2, pr5.getPreco());

    repositorioItemPedido.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));
  }
}