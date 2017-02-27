package org.lwerl.caloriesmng.repository.jpa;

import org.lwerl.caloriesmng.model.User;
import org.lwerl.caloriesmng.model.UserMeal;
import org.lwerl.caloriesmng.repository.UserMealRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;


@Transactional(readOnly = true)
@Repository
public class JpaMealRepository implements UserMealRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        userMeal.setUser(entityManager.getReference(User.class, userId));
        if (userMeal.isNew()) entityManager.persist(userMeal);
        else {
            if (get(userMeal.getId(), userId) == null) return null;
            entityManager.merge(userMeal);
        }
        return userMeal;
    }

    @Transactional
    @Override
    public boolean delete(int id, int userId) {
        return (entityManager.createNamedQuery(UserMeal.DELETE)
                .setParameter("id", id)
                .setParameter("userId", userId)
                .executeUpdate() != 0);
    }

    @Override
    public UserMeal get(int id, int userId) {
        List<UserMeal> userMeals = entityManager.createNamedQuery(UserMeal.GET, UserMeal.class)
                .setParameter("id", id)
                .setParameter("userId", userId)
                .getResultList();
        return userMeals.size() == 0 ? null : DataAccessUtils.requiredSingleResult(userMeals);
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return entityManager.createNamedQuery(UserMeal.ALL_SORTED, UserMeal.class)
                .setParameter("userId",userId)
                .getResultList();
    }

    @Transactional
    @Override
    public void deleteAll(int userId) {
        entityManager.createNamedQuery(UserMeal.DELETE_ALL).setParameter("userId",userId).executeUpdate();
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return entityManager.createNamedQuery(UserMeal.GET_BETWEEN, UserMeal.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .setParameter("userId", userId)
                .getResultList();
    }
}