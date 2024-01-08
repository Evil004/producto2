package org.example.producto2.models.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.producto2.models.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MenuDAOImpl implements MenuDAO{

    private final EntityManager entityManager;

    @Autowired
    public MenuDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    @Transactional
    public void save(Menu menu) {
    entityManager.persist(menu);
    }

    @Override
    public Menu findById(long id) {
        return entityManager.find(Menu.class, id);
    }

    @Override
    public Menu[] findAll() {
        Query q1 = entityManager.createQuery("from Menu ");

        return (Menu[]) q1.getResultList().toArray(Menu[]::new);
    }

    @Override
    public void update(Menu menu) {

        entityManager.merge(menu);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public void deleteAll() {
        Query q1 = entityManager.createQuery("delete from Menu ");
        q1.executeUpdate();
    }
}
