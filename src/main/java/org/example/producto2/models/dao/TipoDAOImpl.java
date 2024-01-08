package org.example.producto2.models.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.example.producto2.models.entity.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TipoDAOImpl implements TipoDAO{

    private EntityManager entityManager;

    @Autowired
    public TipoDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Tipo tipo) {
        entityManager.persist(tipo);
    }

    @Override
    public Tipo findByID(int id) {
        return entityManager.find(Tipo.class, id);
    }

    @Override
    public List<Tipo> findAll() {
        TypedQuery<Tipo> theQuery = entityManager.createQuery("FROM Tipo", Tipo.class);
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
        entityManager.createQuery("DELETE FROM Tipo").executeUpdate();
    }

    @Override
    @Transactional
    public void update(Tipo tipo) {
        entityManager.merge(tipo);
    }
}
