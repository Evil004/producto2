package org.example.producto2.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.producto2.models.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoDAOImpl implements  PedidoDAO{

    private final EntityManager entityManager;

    @Autowired
    public PedidoDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public void save(Pedido pedido) {
        entityManager.persist(pedido);
    }

    @Override
    public Pedido findById(long id) {
        return entityManager.find(Pedido.class, id);
    }

    @Override
    public Pedido[] findAll() {
        Query q1 = entityManager.createQuery("from Pedido ");

        return (Pedido[]) q1.getResultList().toArray(Pedido[]::new);
    }

    @Override
    public void update(Pedido pedido) {
        entityManager.merge(pedido);

    }

    @Override
    public void delete(long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public void deleteAll() {
        Query q1 = entityManager.createQuery("delete from Pedido ");
        q1.executeUpdate();
    }
}
