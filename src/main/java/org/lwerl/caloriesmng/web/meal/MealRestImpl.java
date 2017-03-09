package org.lwerl.caloriesmng.web.meal;

import org.lwerl.caloriesmng.LoggedUser;
import org.lwerl.caloriesmng.model.UserMeal;
import org.lwerl.caloriesmng.service.UserMealService;
import org.lwerl.caloriesmng.util.LoggerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MealRestImpl implements MealRest {
    private static final LoggerWrapper LOG = LoggerWrapper.get(MealRestImpl.class);
    //не имеет перменных, то есть не имеет состояния - ThreadSafe

    private UserMealService service;

    @Autowired
    private MealRestImpl(UserMealService service) {
        this.service = service;
    }

    //@Required
    public void setService(UserMealService service) {
        this.service = service;
    }

    @Override
    public UserMeal get(int id) {
        int userId = LoggedUser.LOGGED_USER.getId();
        LOG.info("get meal {} for User {}", id, userId);
        return service.get(id, userId);
    }

    @Override
    public void delete(int id) {
        int userId = LoggedUser.LOGGED_USER.getId();
        LOG.info("delete meal {} for User {}", id, userId);
        service.delete(id, userId);
    }

    @Override
    public List<UserMeal> getAll() {
        int userId = LoggedUser.LOGGED_USER.getId();
        LOG.info("get all meal for User {}", userId);
        return service.getAll(userId);
    }

    @Override
    public void deleteAll() {
        int userId = LoggedUser.LOGGED_USER.getId();
        LOG.info("delete all meal for User {}", userId);
        service.deleteAll(userId);
    }

    @Override
    public void update(UserMeal meal) {
        int userId = LoggedUser.LOGGED_USER.getId();
        LOG.info("update meal {} for User {}", meal, userId);
        service.update(meal, userId);
    }

    @Override
    public void create(UserMeal meal) {
        int userId = LoggedUser.LOGGED_USER.getId();
        LOG.info("create meal {} for User {}", meal, userId);
        service.save(meal, userId);
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate) {
        int userId = LoggedUser.LOGGED_USER.getId();
        LOG.info("get meal between {} and {} for User {}", startDate, endDate, userId);
        return service.getBetween(startDate, endDate, userId);
    }
}