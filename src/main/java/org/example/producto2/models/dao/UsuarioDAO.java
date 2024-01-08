package org.example.producto2.models.dao;

import org.example.producto2.models.entity.Usuario;

public interface UsuarioDAO {
    void save(Usuario usuario);

    Usuario findById(long id);

    Usuario[] findAll();

    void update(Usuario usuario);

    void delete(long id);

    void deleteAll();
}
