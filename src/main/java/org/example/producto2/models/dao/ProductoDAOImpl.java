package org.example.producto2.models.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.example.producto2.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoDAOImpl implements ProductoDAO{

    private EntityManager entityManager;

    @Autowired
    public ProductoDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        entityManager.persist(producto);
    }

    @Override
    public Producto findByID(int id) {
        return entityManager.find(Producto.class, id);
    }

    @Override
    public List<Producto> findAll() {
        TypedQuery<Producto> theQuery = entityManager.createQuery("FROM Producto", Producto.class);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(findByID(id));
    }

    @Override
    @Transactional
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM Producto ").executeUpdate();
    }

    @Override
    @Transactional
    public void update(Producto producto) {
        entityManager.merge(producto);
    }
}
