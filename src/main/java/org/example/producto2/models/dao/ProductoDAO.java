package org.example.producto2.models.dao;

import org.example.producto2.models.entity.Producto;

import java.util.List;

public interface ProductoDAO {

    void save(Producto producto);

    Producto findByID(int id);

    List<Producto> findAll();

    void delete(int id);

    void deleteAll();

    void update(Producto producto);
}
