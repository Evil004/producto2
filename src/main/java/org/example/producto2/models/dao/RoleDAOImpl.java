package org.example.producto2.models.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.example.producto2.models.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO {

    private final EntityManager entityManager;

    @Autowired
    public RoleDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    @Transactional
    public void save(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role findById(long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role[] findAll() {
        Query q1 = entityManager.createQuery("from Role");

        return (Role[]) q1.getResultList().toArray(Role[]::new);
    }

    @Override
    @Transactional
    public void update(Role role) {

            entityManager.merge(role);
    }

    @Override
    @Transactional
    public void delete(long id) {
        entityManager.remove(findById(id));
    }

    @Override
    @Transactional
    public void deleteAll() {
        Query q1 = entityManager.createQuery("delete from Role ");
        q1.executeUpdate();
    }
}
