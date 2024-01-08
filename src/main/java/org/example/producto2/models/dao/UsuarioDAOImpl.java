package org.example.producto2.models.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.example.producto2.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

    private final EntityManager entityManager;

    @Autowired
    public UsuarioDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    @Transactional
    public void save(Usuario usuario) {
        entityManager.persist(usuario);
    }

    @Override
    public Usuario findById(long id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public Usuario[] findAll() {
        Query q1 = entityManager.createQuery("from Usuario ");

        return (Usuario[]) q1.getResultList().toArray(Usuario[]::new);
    }

    @Override
    public void update(Usuario usuario) {

            entityManager.merge(usuario);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public void deleteAll() {
        Query q1 = entityManager.createQuery("delete from Usuario ");
        q1.executeUpdate();
    }
}
