package org.example.producto2.dao;

import org.example.producto2.models.entity.Pedido;

public interface PedidoDAO {
    void save(Pedido pedido);

    Pedido findById(long id);

    Pedido[] findAll();

    void update(Pedido pedido);

    void delete(long id);

    void deleteAll();

}
