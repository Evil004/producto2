package org.example.producto2.models.dao;

import org.example.producto2.models.entity.Role;

public interface RoleDAO {
    void save(Role rol);

    Role findById(long id);

    Role[] findAll();

    void update(Role rol);

    void delete(long id);

    void deleteAll();
}
