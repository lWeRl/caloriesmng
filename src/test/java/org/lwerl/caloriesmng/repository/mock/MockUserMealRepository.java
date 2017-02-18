package org.lwerl.caloriesmng.repository.mock;

import org.lwerl.caloriesmng.model.UserMeal;
import org.lwerl.caloriesmng.repository.UserMealRepository;
import org.lwerl.caloriesmng.util.LoggerWrapper;
import org.lwerl.caloriesmng.util.TimeUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MockUserMealRepository implements UserMealRepository {
    private static final LoggerWrapper LOG = LoggerWrapper.get(MockUserMealRepository.class);

    @PostConstruct//после инициализации бинов в контексте
    public void postConstruct() {
        LOG.info("PostConstruct");
    }

    @PreDestroy//перед уничтожением бинов в контексте и его самого
    public void preDestroy() {
        LOG.info("PreDestroy");
    }

    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        LOG.info("Save " + userMeal);
        return userMeal;
    }

    @Override
    public boolean delete(int id, int userId) {
        LOG.info("Delete" + id);
        return id != 0;
    }

    @Override
    public UserMeal get(int id, int userId) {
        LOG.info("Get " + id);
        return null;
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        LOG.info("Get all");
        return null;
    }

    @Override
    public void deleteAll(int userId) {
        LOG.info("Delete all");
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        LOG.info("Get Between " + TimeUtil.toString(startDate) + " " + TimeUtil.toString(endDate));
        return null;
    }
}
