package org.example.producto2.models.dao;

import org.example.producto2.models.entity.Producto;
import org.example.producto2.models.entity.Tipo;

import java.util.List;

public interface TipoDAO {

    void save(Tipo tipo);

    Tipo findByID(int id);

    List<Tipo> findAll();

    void delete(int id);

    void deleteAll();

    void update(Tipo tipo);

}
